import requests
import json
import time
from striprtf.striprtf import rtf_to_text

# File containing tweets (one tweet per line in RTF format)
TWEET_FILE = '/Users/shyamtiwari/Library/Mobile Documents/com~apple~TextEdit/Documents/tweets.rtf'

# API endpoint
API_URL = 'https://x.com/i/api/graphql/BjT3MvG1CwfTuJxTLX4ovg/CreateTweet'

# Headers for the request
HEADERS = {
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

# Function to post tweets
def post_tweets(file_name, delay=25):
    try:
        with open(file_name, 'r') as file:
            tweets = file.readlines()

        for index, tweet in enumerate(tweets, start=1):
            # Convert RTF to plain text
            tweet_text = rtf_to_text(tweet).strip()  # Remove extra spaces or newlines
            if tweet_text:
                payload = {
                    "variables": {
                        "tweet_text": tweet_text,
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
                    },
                    "queryId": "BjT3MvG1CwfTuJxTLX4ovg"
                }

                response = requests.post(API_URL, headers=HEADERS, json=payload)
                if response.status_code == 200:
                    print(f"{index}: Tweet posted successfully: {tweet_text}")
                else:
                    print(f"{index}: Failed to post tweet: {tweet_text}")
                    print(f"Response: {response.status_code}, {response.text}")

                # Delay between tweets
                time.sleep(delay)


    except Exception as e:
        print(f"An error occurred: {e}")

# Run the script
if __name__ == "__main__":
    post_tweets(TWEET_FILE, delay=25)
