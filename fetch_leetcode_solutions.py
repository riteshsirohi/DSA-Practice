import os
import requests
from github import Github

# LeetCode credentials
LEETCODE_USERNAME = os.getenv('LEETCODE_USERNAME')
LEETCODE_PASSWORD = os.getenv('LEETCODE_PASSWORD')

# GitHub credentials
REPO_ACCESS_TOKEN = os.getenv('REPO_ACCESS_TOKEN')
REPO_NAME = os.getenv('REPO_NAME')

# LeetCode API URL
LEETCODE_GRAPHQL_URL = "https://leetcode.com/graphql/"

# Authenticate with LeetCode and fetch submissions
def fetch_leetcode_submissions(username, password):
    session = requests.Session()
    session.post('https://leetcode.com/accounts/login/', data={
        'login': username,
        'password': password
    })
    query = '''
    query recentAcSubmissions($username: String!, $limit: Int!) {
      recentAcSubmissionList(username: $username, limit: $limit) {
        title
        code
        lang
      }
    }
    '''
    variables = {
        'username': username,
        'limit': 100
    }
    response = session.post(LEETCODE_GRAPHQL_URL, json={'query': query, 'variables': variables})
    return response.json()['data']['recentAcSubmissionList']

submissions = fetch_leetcode_submissions(LEETCODE_USERNAME, LEETCODE_PASSWORD)

# Authenticate with GitHub
g = Github(REPO_ACCESS_TOKEN)
repo = g.get_repo(REPO_NAME)

for submission in submissions:
    problem_title = submission['title'].replace(" ", "_")
    code = submission['code']
    lang = submission['lang']
    extension = {
        'python': '.py',
        'java': '.java',
        'cpp': '.cpp'
    }.get(lang.lower(), '.txt')

    # Save the code to a file
    filename = f"solutions/{problem_title}{extension}"
    if not os.path.exists('solutions'):
        os.makedirs('solutions')
    with open(filename, "w") as f:
        f.write(code)

    # Check if the file already exists in the repository
    try:
        contents = repo.get_contents(filename)
        repo.update_file(contents.path, f"Update solution for {problem_title}", code, contents.sha, branch="main")
    except:
        repo.create_file(filename, f"Add solution for {problem_title}", code, branch="main")
