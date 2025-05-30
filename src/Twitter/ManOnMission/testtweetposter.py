import requests
import json
import time
import random
from striprtf.striprtf import rtf_to_text


TWEET_FILE = '/Users/shyamtiwari/Library/Mobile Documents/com~apple~TextEdit/Documents/tweets.rtf'
CREATE_API_URL = 'https://x.com/i/api/graphql/BjT3MvG1CwfTuJxTLX4ovg/CreateTweet'
LIKE_API_URL = 'https://x.com/i/api/graphql/lI07N6Otwv1PhnEgXILM7A/FavoriteTweet'
CREATE_API_HEADERS = {
    'accept': '*/*',
    'accept-language': 'en-IN,en;q=0.9,hi-IN;q=0.8,hi;q=0.7,en-GB;q=0.6,en-US;q=0.5,pa;q=0.4,ne;q=0.3,bn;q=0.2,ur;q=0.1',
    'authorization': 'Bearer AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA',
    'content-type': 'application/json',
    'cookie': 'lang=en; night_mode=2; kdt=xnZcYoE7S4i3XTx4Nhc3zrOov8P9T4NhcwiyDKL3; g_state={"i_l":0}; twtr_pixel_opt_in=N; _ga=GA1.2.259588237.1735238696; _ga_KEWZ1G5MB3=GS1.2.1735238696.1.0.1735238696.60.0.0; ads_prefs="HBIRAAA="; auth_multi="2589485844:654c024c9784be0278cfd1bdf239bd5823f36f19|1548369007631167491:62e10c62885930c8f82da8dcff78e25cc8b491e6"; auth_token=4e5163b4c574b594b2fc27e5d4cea52b245ac75c; guest_id_ads=v1%3A173712014111041721; guest_id_marketing=v1%3A173712014111041721; guest_id=v1%3A173712014111041721; twid=u%3D1085788904; ct0=d7c75ad9ea359dfb06c09a6e0627e7b4d9acd7cd3a3f0f6d713cd3aac5c020a52db3a69a0b12ac371fe3d7c24a4862d9e8b32f4df464876f70dde424315b3c5737767dfb5f1644d3e0c00369ddfb9c4e; personalization_id="v1_n8Sa+5mqR5JrxGTmsIyrcg=="',
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
    'x-client-transaction-id': '10vOqPVCn+W8E9rDRt8u9WLrRtPelbHPXmUD/gMQth+Acp8hbb3bFt2k1N+GnFuhE1bG69RP2lA+Kp9kVS9V6HzHU4fH1A',
    'x-csrf-token': 'd7c75ad9ea359dfb06c09a6e0627e7b4d9acd7cd3a3f0f6d713cd3aac5c020a52db3a69a0b12ac371fe3d7c24a4862d9e8b32f4df464876f70dde424315b3c5737767dfb5f1644d3e0c00369ddfb9c4e',
    'x-twitter-active-user': 'yes',
    'x-twitter-auth-type': 'OAuth2Session',
    'x-twitter-client-language': 'en'
}
LIKE_API_HEADERS = {
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
def post_and_like_tweet(file_name, delay=5):
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
                        like_tweets(rest_id)
                else:

                    print(f"{index}: Failed to post tweet: {tweet_text}")
                    print(f"Response: {response.status_code}, {response.text}")
                time.sleep(delay)

    except Exception as e:

        print(f"An error occurred: {e}")


def like_tweets(tweet_id):
         try:
            payload = {"variables": {"tweet_id": tweet_id}, "queryId": "lI07N6Otwv1PhnEgXILM7A"}
            response = requests.post(LIKE_API_URL, headers=LIKE_API_HEADERS, json=payload)
            if response.status_code == 200:
                print(f"Successfully liked tweet: {tweet_id}")
            else:
                print(f"Failed to like tweet: {tweet_id}. Response: {response.status_code}, {response.text}")
         except Exception as e:
            print(f"An error occurred: {e}")


# Run the script
if __name__ == "__main__":
    post_and_like_tweet(TWEET_FILE, delay=5)
