import requests
import random
import time
from striprtf.striprtf import rtf_to_text

TO_LIKE_TWEET_IDS = ['1883179168915214587', '1883179194555011201', '1883179225018249649', '1883179250808947147', '1883179276314583105', '1883179301883048242', '1883179327543710149', '1883179353233879516', '1883179378731065492', '1883179404358193154', '1883179429951897972', '1883179455541338297', '1883179481889923325', '1883179507823329374', '1883179533383413912', '1883179559010587035', '1883179584503644554', '1883179610076324263', '1883179635762217187', '1883179661271941172', '1883179687167627639', '1883179712668954728', '1883179738279362973', '1883179763935985737', '1883179789512786286', '1883179815177716110', '1883179841077604850', '1883179866658685354', '1883179892248064039', '1883179917808128244', '1883179943397655010', '1883179969154801817', '1883181346136412556', '1883181371910406275']

# File containing tweet IDs in a list format like ['id1','id2','id3']
TWEET_FILE = '/Users/shyamtiwari/Library/Mobile Documents/com~apple~TextEdit/Documents/TweetstobeLikedId.rtf'  # Replace with your actual file path

# API endpoint for liking a tweet
API_URL = 'https://x.com/i/api/graphql/lI07N6Otwv1PhnEgXILM7A/FavoriteTweet'

# Headers for the request
HEADERS = {
    'accept': '*/*',
    'accept-language': 'en-IN,en;q=0.9,hi-IN;q=0.8,hi;q=0.7,en-GB;q=0.6,en-US;q=0.5,pa;q=0.4,ne;q=0.3,bn;q=0.2,ur;q=0.1',
    'authorization': 'Bearer AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA',  # Replace with your actual token
    'content-type': 'application/json',
    'cookie': 'lang=en; night_mode=2; kdt=xnZcYoE7S4i3XTx4Nhc3zrOov8P9T4NhcwiyDKL3; g_state={"i_l":0}; twtr_pixel_opt_in=N; _ga=GA1.2.259588237.1735238696; _ga_KEWZ1G5MB3=GS1.2.1735238696.1.0.1735238696.60.0.0; des_opt_in=N; personalization_id="v1_n8Sa+5mqR5JrxGTmsIyrcg=="; dnt=1; ads_prefs="HBESAAA="; auth_multi="1085788904:4e5163b4c574b594b2fc27e5d4cea52b245ac75c|2589485844:654c024c9784be0278cfd1bdf239bd5823f36f19"; auth_token=62e10c62885930c8f82da8dcff78e25cc8b491e6; guest_id_ads=v1%3A173779568268895939; guest_id_marketing=v1%3A173779568268895939; guest_id=v1%3A173779568268895939; twid=u%3D1548369007631167491; ct0=b2e24f0f6c5093ac661e4361b2766861afa12296cdba1421c49a10440e149db0eebe802b4fa4793a9ed1e9d82cdd96617972ed71abffb39f4f3ab7aff2ebd200b8395ded835934ba77f64cf6fdb10932',
    'origin': 'https://x.com',
    'priority': 'u=1, i',
    'referer': 'https://x.com/home',
    'sec-ch-ua': '"Google Chrome";v="131", "Chromium";v="131", "Not_A Brand";v="24"',
    'sec-ch-ua-mobile': '?0',
    'sec-ch-ua-platform': '"macOS"',
    'sec-fetch-dest': 'empty',
    'sec-fetch-mode': 'cors',
    'sec-fetch-site': 'same-origin',
    'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36',
    'x-client-transaction-id': 'nRB8kNRhcdIbBbNBwmOvdCDD8qBDMIfZYMQDnynsFBtXdUPM4U6g5nsdbs6SrWOowsj/2Z4HnfT87kdcQVfXy5BZHUC3ng',  # Replace with actual value
    'x-csrf-token': 'b2e24f0f6c5093ac661e4361b2766861afa12296cdba1421c49a10440e149db0eebe802b4fa4793a9ed1e9d82cdd96617972ed71abffb39f4f3ab7aff2ebd200b8395ded835934ba77f64cf6fdb10932',
    'x-twitter-active-user': 'yes',
    'x-twitter-auth-type': 'OAuth2Session',
    'x-twitter-client-language': 'en',
}

# Function to get random query ID
def generate_random_query_id():
    return str(random.randint(1, 1000000))  # Example random query ID generation

# Function to like tweets
def like_tweets(file_name, delay=5):
    try:
#         # Read the RTF file and extract the list of tweet IDs
#         with open(file_name, 'r') as file:
#             rtf_content = file.read()
#         tweet_ids_raw = rtf_to_text(rtf_content).strip()
#
#         # Convert the string list to a Python list
#         tweet_ids = eval(tweet_ids_raw)  # Ensure the input is safe and properly formatted

        for tweet_id in TO_LIKE_TWEET_IDS:
            if tweet_id:
                payload = {
                    "variables": {
                        "tweet_id": tweet_id
                    },
                    "queryId": generate_random_query_id()  # Generate a random query ID
                }

                response = requests.post(API_URL, headers=HEADERS, json=payload)

                if response.status_code == 200:
                    print(f"Successfully liked tweet: {tweet_id}")
                else:
                    print(f"Failed to like tweet: {tweet_id}. Response: {response.status_code}, {response.text}")

                # Delay between likes
                time.sleep(delay)

    except Exception as e:
        print(f"An error occurred: {e}")

# Run the script
if __name__ == "__main__":
    like_tweets(TWEET_FILE, delay=5)  # Adjust delay as needed
