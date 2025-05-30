import requests
import json
import time
import random

from striprtf.striprtf import rtf_to_text


TWEET_FILE = '/Users/shyamtiwari/Library/Mobile Documents/com~apple~TextEdit/Documents/tweets.rtf'
CREATE_API_URL = 'https://x.com/i/api/graphql/BjT3MvG1CwfTuJxTLX4ovg/CreateTweet'
SHIVAM_LIKE_API_URL = 'https://x.com/i/api/graphql/lI07N6Otwv1PhnEgXILM7A/FavoriteTweet'
SHYAM_LIKE_API_URL = 'https://x.com/i/api/graphql/lI07N6Otwv1PhnEgXILM7A/FavoriteTweet'


url = "https://x.com/i/api/graphql/_aUkOlYcrHMY3LR-lUVuSg/CreateTweet"
headers = {
    "accept": "*/*",
    "accept-language": "en-IN,en;q=0.9",
    "authorization": "Bearer AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA",
    "content-type": "application/json",
    "cookie": 'night_mode=2; kdt=cGAiUxdw7PN2IMtefAMRuHdVkZC9mswJRS6ZxD4e; g_state={"i_l":0}; twtr_pixel_opt_in=N; lang=en; __cf_bm=fUsiL6VnsUkqPzQ7NjUdxWQ6pT44xSNVNAe6MqO1YfM-1743241688-1.0.1.1-KTuB.454aWlPbMJuQqR11Co5nOjZCISXFyr9GgXKVvx38f_1hFHJE2q93IvUiyWO6pXV3bD0glh0LglpSoYWH7IFp75cR3Fav4CO8bBgFyI; dnt=1; ads_prefs="HBESAAA="; auth_multi="1085788904:73d8e92d2d9d145225ede613d16341b3b3ded913"; auth_token=ff25833e92c5575f7dffa92eb2677a35026bcbee; guest_id_ads=v1%3A174324221441058098; guest_id_marketing=v1%3A174324221441058098; guest_id=v1%3A174324221441058098; twid=u%3D1548369007631167491; ct0=0f1817a6a77ed77516cab6a902491e2cfba43e61ba954b8bd0c9f34476c49aa85d8e1ee4985cc2f84ef4209a52725d5e8536886f9ab3145052907c3b1492d1d34e3d586b92f75750c806203fb5e1b076; personalization_id="v1_cQYcLX/TTbKfLu7mI8EwuQ=="',
    "origin": "https://x.com",
    "referer": "https://x.com/IronDiscipline_/status/1870772076635881836",
    "sec-ch-ua": '"Google Chrome";v="131", "Chromium";v="131", "Not_A Brand";v="24"',
    "sec-ch-ua-mobile": "?0",
    "sec-ch-ua-platform": '"macOS"',
    "user-agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36",
    "x-client-transaction-id": "fJYnZXGafElDKN08m9tIm1VuAetdjU4VXd0s1MvmYOV/gEVl9lpmuVOnHFkflaODr6gc5H9BSx1npdWgAeVTgVKD/L91fw",
    "x-csrf-token": "0f1817a6a77ed77516cab6a902491e2cfba43e61ba954b8bd0c9f34476c49aa85d8e1ee4985cc2f84ef4209a52725d5e8536886f9ab3145052907c3b1492d1d34e3d586b92f75750c806203fb5e1b076",
    "x-twitter-active-user": "yes",
    "x-twitter-auth-type": "OAuth2Session",
    "x-twitter-client-language": "en",
}
payload_template = {
    "variables": {
        "tweet_text": "",
        "reply": {
            "in_reply_to_tweet_id": "1884620681914278296",
            "exclude_reply_user_ids": []
        },
        "dark_request": False,
        "media": {
            "media_entities": [],
            "possibly_sensitive": False
        },
        "semantic_annotation_ids": [],
        "disallowed_reply_options": None
    },
    "features": {
        "premium_content_api_read_enabled": False,
        "communities_web_enable_tweet_community_results_fetch": True,
        "c9s_tweet_anatomy_moderator_badge_enabled": True,
        "responsive_web_grok_analyze_button_fetch_trends_enabled": False,
        "responsive_web_grok_analyze_post_followups_enabled": True,
        "responsive_web_jetfuel_frame": False,
        "responsive_web_grok_share_attachment_enabled": True,
        "responsive_web_edit_tweet_api_enabled": True,
        "graphql_is_translatable_rweb_tweet_is_translatable_enabled": True,
        "view_counts_everywhere_api_enabled": True,
        "longform_notetweets_consumption_enabled": True,
        "responsive_web_twitter_article_tweet_consumption_enabled": True,
        "tweet_awards_web_tipping_enabled": False,
        "creator_subscriptions_quote_tweet_preview_enabled": False,
        "longform_notetweets_rich_text_read_enabled": True,
        "longform_notetweets_inline_media_enabled": True,
        "profile_label_improvements_pcf_label_in_post_enabled": True,
        "rweb_tipjar_consumption_enabled": True,
        "responsive_web_graphql_exclude_directive_enabled": True,
        "verified_phone_label_enabled": True,
        "articles_preview_enabled": True,
        "rweb_video_timestamps_enabled": True,
        "responsive_web_graphql_skip_user_profile_image_extensions_enabled": False,
        "freedom_of_speech_not_reach_fetch_enabled": True,
        "standardized_nudges_misinfo": True,
        "tweet_with_visibility_results_prefer_gql_limited_actions_policy_enabled": True,
        "responsive_web_grok_image_annotation_enabled": True,
        "responsive_web_graphql_timeline_navigation_enabled": True,
        "responsive_web_enhance_cards_enabled": False
    },
    "queryId": "_aUkOlYcrHMY3LR-lUVuSg"
}
CREATE_API_HEADERS = {
    'accept': '*/*',
    'accept-language': 'en-IN,en;q=0.9,hi-IN;q=0.8,hi;q=0.7,en-GB;q=0.6,en-US;q=0.5,pa;q=0.4,ne;q=0.3,bn;q=0.2,ur;q=0.1',
    'authorization': 'Bearer AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA',
    'content-type': 'application/json',
    'cookie': 'night_mode=2; kdt=cGAiUxdw7PN2IMtefAMRuHdVkZC9mswJRS6ZxD4e; g_state={"i_l":0}; twtr_pixel_opt_in=N; personalization_id="v1_cQYcLX/TTbKfLu7mI8EwuQ=="; lang=en; att=1-xFzrXOjWnL27cKS0tPtzsxGnw4CWYQp5GXhqiFJG; ads_prefs="HBIRAAA="; auth_token=49a2b5a219cb2e04c352735523da12ce54515564; twid=u%3D1085788904; guest_id=v1%3A174030948112146762; ct0=83a909cb136d0340c1d4b05de82f1eb70178e7439415788942a0649abab1e054007e3e6f3ac5e7eda359e7b3ee7f0d8a9ff333e64a9362d2d3d4f748190169f5413c130fb7dec563966e3bbb60f6c156; guest_id_ads=v1%3A174030948112146762; guest_id_marketing=v1%3A174030948112146762',
    'origin': 'https://x.com',
    'priority': 'u=1, i',
    'referer': 'https://x.com/compose/post',
    'sec-ch-ua': '"Google Chrome";v="131", "Chromium";v="131", "Not_A Brand";v="24"',
    'sec-ch-ua-mobile': '?0',
    'sec-ch-ua-platform': '"macOS"',
    'sec-fetch-dest': 'empty',
    'sec-fetch-mode': 'cors',
    'sec-fetch-site': 'same-origin',
    'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36',
    'x-client-transaction-id': 'DWOny8NjUWMt+SCXtimAZIZm60EEqQbQxWMR+Ul4+1/0SRakZhFJIcKfj9/GWc2h53W7Zg6g+NybyDEWRJ1pqaJffttADg',
    'x-csrf-token': '83a909cb136d0340c1d4b05de82f1eb70178e7439415788942a0649abab1e054007e3e6f3ac5e7eda359e7b3ee7f0d8a9ff333e64a9362d2d3d4f748190169f5413c130fb7dec563966e3bbb60f6c156',
    'x-twitter-active-user': 'yes',
    'x-twitter-auth-type': 'OAuth2Session',
    'x-twitter-client-language': 'en'
}
SHIVAM_LIKE_API_HEADERS = {
    'accept': '*/*',
    'accept': '*/*',
    'accept-language': 'en-IN,en;q=0.9,hi-IN;q=0.8,hi;q=0.7,en-GB;q=0.6,en-US;q=0.5,pa;q=0.4,ne;q=0.3,bn;q=0.2,ur;q=0.1',
    'authorization': 'Bearer AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA',  # Replace with your actual token
    'content-type': 'application/json',
    'cookie': 'night_mode=2; kdt=cGAiUxdw7PN2IMtefAMRuHdVkZC9mswJRS6ZxD4e; g_state={"i_l":0}; twtr_pixel_opt_in=N; lang=en; __cf_bm=fUsiL6VnsUkqPzQ7NjUdxWQ6pT44xSNVNAe6MqO1YfM-1743241688-1.0.1.1-KTuB.454aWlPbMJuQqR11Co5nOjZCISXFyr9GgXKVvx38f_1hFHJE2q93IvUiyWO6pXV3bD0glh0LglpSoYWH7IFp75cR3Fav4CO8bBgFyI; dnt=1; ads_prefs="HBESAAA="; auth_multi="1085788904:73d8e92d2d9d145225ede613d16341b3b3ded913"; auth_token=ff25833e92c5575f7dffa92eb2677a35026bcbee; guest_id_ads=v1%3A174324221441058098; guest_id_marketing=v1%3A174324221441058098; guest_id=v1%3A174324221441058098; twid=u%3D1548369007631167491; ct0=0f1817a6a77ed77516cab6a902491e2cfba43e61ba954b8bd0c9f34476c49aa85d8e1ee4985cc2f84ef4209a52725d5e8536886f9ab3145052907c3b1492d1d34e3d586b92f75750c806203fb5e1b076; personalization_id="v1_cQYcLX/TTbKfLu7mI8EwuQ==',
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
    'x-client-transaction-id': 'fJYnZXGafElDKN08m9tIm1VuAetdjU4VXd0s1MvmYOV/gEVl9lpmuVOnHFkflaODr6gc5H9BSx1npdWgAeVTgVKD/L91fw',  # Replace with actual value
    'x-csrf-token': 'b2e24f0f6c5093ac661e4361b2766861afa12296cdba1421c49a10440e149db0eebe802b4fa4793a9ed1e9d82cdd96617972ed71abffb39f4f3ab7aff2ebd200b8395ded835934ba77f64cf6fdb10932',
    'x-twitter-active-user': 'yes',
    'x-twitter-auth-type': 'OAuth2Session',
    'x-twitter-client-language': 'en',
}
SHYAM_LIKE_API_HEADERS = {
    'accept':'*/*',
    'accept-language':'en-IN,en;q=0.9,hi-IN;q=0.8,hi;q=0.7,en-GB;q=0.6,en-US;q=0.5,pa;q=0.4,ne;q=0.3,bn;q=0.2,ur;q=0.1',
    'authorization':'Bearer AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA',
    'content-type':'application/json',
    'cookie':'lang=en; night_mode=2; kdt=xnZcYoE7S4i3XTx4Nhc3zrOov8P9T4NhcwiyDKL3; g_state={"i_l":0}; twtr_pixel_opt_in=N; _ga=GA1.2.259588237.1735238696; _ga_KEWZ1G5MB3=GS1.2.1735238696.1.0.1735238696.60.0.0; des_opt_in=N; _gid=GA1.2.1359195043.1737800753; ph_phc_TXdpocbGVeZVm5VJmAsHTMrCofBQu3e0kN8HGMNGTVW_posthog=%7B%22distinct_id%22%3A%2201949d04-44a0-7b7d-a581-8d4b768314f8%22%2C%22%24sesid%22%3A%5B1737801090264%2C%2201949d04-449f-75ca-8fdb-1a21a6639635%22%2C1737801090207%5D%7D; personalization_id="v1_n8Sa+5mqR5JrxGTmsIyrcg=="; ads_prefs="HBERAAA="; auth_multi="1085788904:4e5163b4c574b594b2fc27e5d4cea52b245ac75c|1548369007631167491:62e10c62885930c8f82da8dcff78e25cc8b491e6"; auth_token=654c024c9784be0278cfd1bdf239bd5823f36f19; guest_id_ads=v1%3A173786535658074122; guest_id_marketing=v1%3A173786535658074122; guest_id=v1%3A173786535658074122; twid=u%3D2589485844; ct0=951df965b53d40d3738f8d8d8ae94073612b7816ef1927ab915dcce9754e40fb2aa82f970c45c1cb8a6f8c0f59c16de010ebcbeb233b25276385496c1ca6d64433f8fe812c881a575edfc56737e118e6',
    'origin':'https://x.com',
    'priority':'u=1, i',
    'referer':'https://x.com/home',
    'sec-ch-ua':'"Google Chrome";v="131", "Chromium";v="131", "Not_A Brand";v="24"',
    'sec-ch-ua-mobile':'?0',
    'sec-ch-ua-platform':'macOS',
    'sec-fetch-dest':'empty',
    'sec-fetch-mode':'cors',
    'sec-fetch-site':'same-origin',
    'user-agent':'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36',
    'x-client-transaction-id':'+J107BPj4dEMcRGzhNy8vG5WCx9lk+mY/6WBwv13mGFt1vqFJTGc1STvCPYob2hLFMmtvvsuMZVXIkPq9ezz31h7EirY+w',
    'x-csrf-token':'951df965b53d40d3738f8d8d8ae94073612b7816ef1927ab915dcce9754e40fb2aa82f970c45c1cb8a6f8c0f59c16de010ebcbeb233b25276385496c1ca6d64433f8fe812c881a575edfc56737e118e6',
    'x-twitter-active-user':'yes',
    'x-twitter-auth-type':'OAuth2Session',
    'x-twitter-client-language':'en'}

CREATE_API_FEATURES = {
    "premium_content_api_read_enabled": False,
    "communities_web_enable_tweet_community_results_fetch": True,
    "c9s_tweet_anatomy_moderator_badge_enabled": True,
    "responsive_web_grok_analyze_button_fetch_trends_enabled": True,
    "responsive_web_edit_tweet_api_enabled": True,
    "graphql_is_translatable_rweb_tweet_is_translatable_enabled": True,
    "view_counts_everywhere_api_enabled": True,
    "longform_notetweets_consumption_enabled": True,
    "responsive_web_twitter_article_tweet_consumption_enabled": True,
    "tweet_awards_web_tipping_enabled": False,
    "creator_subscriptions_quote_tweet_preview_enabled": False,
    "longform_notetweets_rich_text_read_enabled": True,
    "longform_notetweets_inline_media_enabled": True,
    "profile_label_improvements_pcf_label_in_post_enabled": False,
    "rweb_tipjar_consumption_enabled": True,
    "responsive_web_graphql_exclude_directive_enabled": True,
    "verified_phone_label_enabled": True,
    "articles_preview_enabled": True,
    "rweb_video_timestamps_enabled": True,
    "responsive_web_graphql_skip_user_profile_image_extensions_enabled": False,
    "freedom_of_speech_not_reach_fetch_enabled": True,
    "standardized_nudges_misinfo": True,
    "tweet_with_visibility_results_prefer_gql_limited_actions_policy_enabled": True,
    "responsive_web_graphql_timeline_navigation_enabled": True,
    "responsive_web_enhance_cards_enabled": False
}

# Function to post and like tweets
def post_and_like_tweet(file_name, delay=269):
    print(f"Reading tweets from file: {file_name}")
    try:
        with open(file_name, 'r') as file:
            tweets = file.readlines()
        for index, tweet in enumerate(tweets, start=1):
            # Convert RTF to plain text
            tweet_text = rtf_to_text(tweet).strip()
            if tweet_text:
                payload = {"variables": {"tweet_text": tweet_text,"dark_request": False,"media": {"media_entities": [],"possibly_sensitive": False},"semantic_annotation_ids": [],"disallowed_reply_options": None},"features": CREATE_API_FEATURES,  "queryId": "BjT3MvG1CwfTuJxTLX4ovg" }
                response = requests.post(CREATE_API_URL, headers=CREATE_API_HEADERS, json=payload)
                if response.status_code == 200:
                    response_json = response.json()
                    rest_id = response_json.get("data", {}).get("create_tweet", {}).get("tweet_results", {}).get("result", {}).get("rest_id")
                    if rest_id:
                        print(f"Successfully posted tweet:{rest_id}, {tweet_text}")
                        # like_tweets(rest_id, SHIVAM_LIKE_API_URL , SHIVAM_LIKE_API_HEADERS , "lI07N6Otwv1PhnEgXILM7A")
                        # post_tweets_for_ids(rest_id ,tweet_text )
                        # like_tweets(rest_id, SHYAM_LIKE_API_URL , SHYAM_LIKE_API_HEADERS , "lI07N6Otwv1PhnEgXILM7A")
                #                         like_tweet_by_make_india_great(rest_id)
                else:

                    print(f"{index}: Failed to post tweet: {tweet_text}")
                    print(f"Response: {response.status_code}, {response.text}")
                time.sleep(delay)

    except Exception as e:

        print(f"An error occurred: {e}")


def like_tweets(tweet_id , url , headers , query_id):
    try:
        payload = {"variables": {"tweet_id": tweet_id}, "queryId": query_id}
        response = requests.post(url, headers=headers, json=payload)
        if response.status_code == 200:
            print(f"Successfully liked tweet: {tweet_id}")
        else:
            print(f"Failed to like tweet: {tweet_id}. Response: {response.status_code}, {response.text}")
    except Exception as e:
        print(f"An error occurred: {e}")
        print(f"An error occurred: {e}")

def like_tweet_by_make_india_great(tweet_id):
    url = "https://x.com/i/api/graphql/lI07N6Otwv1PhnEgXILM7A/FavoriteTweet"
    headers = {
        "sec-ch-ua-platform": '"macOS"',
        "authorization": "Bearer AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA",
        "x-csrf-token": "1968de47cab168a3ad5bf2804bad872c3849d0d6eb0b3f6c93498560f330263ca45d4ddc77b816c169f8d4a51c62369b26b3dd32c534433a3bfd8933e116355aff5f5a52b6c598b569bb452d234288cb",
        "Referer": "https://x.com/IronDiscipline_",
        "X-Client-UUID": "d4f9cacf-3eac-46c1-8914-e9f42883b256",
        "sec-ch-ua": '"Google Chrome";v="131", "Chromium";v="131", "Not_A Brand";v="24"',
        "x-twitter-client-language": "en",
        "sec-ch-ua-mobile": "?0",
        "x-twitter-active-user": "yes",
        "x-client-transaction-id": "f1D8s8TIyaYYdYl1jtsJtsDTOzvQl9zMrpi98hwdskTmcyMOCOVsgn17HmZiwRrSkB7ALXyWw/fR3CPftr2vgHQQs4vefA",
        "x-twitter-auth-type": "OAuth2Session",
        "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36",
        "content-type": "application/json"
    }
    data = {
        "variables": {"tweet_id": tweet_id},
        "queryId": "lI07N6Otwv1PhnEgXILM7A"
    }

    response = requests.post(url, headers=headers, data=json.dumps(data))
    return response.json()

def post_tweets_for_ids(tweet_id , tweet_text):
    print(f"Posting tweets for in_reply_to_tweet_id: {tweet_id}")
    for i in range(1, 3):
        # Update the tweet_text and in_reply_to_tweet_id for each iteration
        payload_template["variables"]["tweet_text"] = tweet_text
        payload_template["variables"]["reply"]["in_reply_to_tweet_id"] = tweet_id
        # Convert payload to JSON
        payload = json.dumps(payload_template)

        # Make the POST request
        response = requests.post(url, headers=headers, data=payload)
        response = requests.post(url, headers=headers, data=payload)

        if response.status_code == 200:
            print(f"Tweet {i} for tweet ID {tweet_id} posted successfully!")
        else:
            print(f"Failed to post tweet {i} for tweet ID {tweet_id}. Response: {response.text}")
            break  # Stop if there's an error


# Run the script
if __name__ == "__main__":
    post_and_like_tweet(TWEET_FILE, delay=269)
