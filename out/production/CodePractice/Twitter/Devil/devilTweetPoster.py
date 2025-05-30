import requests
import json
import time
from striprtf.striprtf import rtf_to_text

# File containing tweets (one tweet per line in RTF format)
TWEET_FILE = '/Users/shyamtiwari/Library/Mobile Documents/com~apple~TextEdit/Documents/tweets2.rtf'

# API endpoint
API_URL = 'https://x.com/i/api/graphql/BjT3MvG1CwfTuJxTLX4ovg/CreateTweet'

# Headers for the request
HEADERS = {
    'accept': '*/*',
    'accept-language': 'en-IN,en;q=0.9,hi-IN;q=0.8,hi;q=0.7,en-GB;q=0.6,en-US;q=0.5,pa;q=0.4,ne;q=0.3,bn;q=0.2,ur;q=0.1',
    'authorization': 'Bearer AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA',
    'content-type': 'application/json',
    'cookie': 'night_mode=2; kdt=cGAiUxdw7PN2IMtefAMRuHdVkZC9mswJRS6ZxD4e; g_state={"i_l":0}; dnt=1; lang=en; auth_multi="1085788904:49a2b5a219cb2e04c352735523da12ce54515564"; guest_id_ads=v1%3A173779398382558923; guest_id_marketing=v1%3A173779398382558923; guest_id=v1%3A173779398382558923; gt=1883224234211565938; auth_token=8ffec2989969b2125ec03f4308deeb3397e51171; ct0=336680d11383d9415ab9889845fa5ac9086de0121f15f6d638a7767c67471a12f7153a7d646e7d3220046fb245a8e84f3d340c21274b1adc58a1c63c41c7cc6c32b3aa0990221b0fd0389a15dcd0b621; att=1-6QBOiIozODA9t74Zu7qJqk0BuHIk2qIs2MP47bef; twid=u%3D1498656826531127296; personalization_id="v1_cQYcLX/TTbKfLu7mI8EwuQ=="',
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
    'x-client-transaction-id': 'YYI/n86nJSjkwGT5cWrQvw89Hm4Fa0wraGO5v96UkTFOvbR9/Ku6AgXodpGMbvU96w7AR2K9YwTlVfu1eVpEoBqqdgkBYg',
    'x-csrf-token': '336680d11383d9415ab9889845fa5ac9086de0121f15f6d638a7767c67471a12f7153a7d646e7d3220046fb245a8e84f3d340c21274b1adc58a1c63c41c7cc6c32b3aa0990221b0fd0389a15dcd0b621',
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
                                  "responsive_web_grok_analyze_post_followups_enabled": True,
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
                              "queryId": "V4aHbVtLzM_0h6XP-1tLcw"
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
