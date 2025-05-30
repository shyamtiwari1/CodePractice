import requests
import json
import time

# Replace with your target endpoint
url = "https://x.com/i/api/graphql/_aUkOlYcrHMY3LR-lUVuSg/CreateTweet"

# Headers from the curl
headers = {
    "accept": "*/*",
    "accept-language": "en-IN,en;q=0.9",
    "authorization": "Bearer AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA",
    "content-type": "application/json",
    "cookie": 'lang=en; night_mode=2; kdt=xnZcYoE7S4i3XTx4Nhc3zrOov8P9T4NhcwiyDKL3; g_state={"i_l":0}; twtr_pixel_opt_in=N; _ga=GA1.2.259588237.1735238696; _ga_KEWZ1G5MB3=GS1.2.1735238696.1.0.1735238696.60.0.0; des_opt_in=N; dnt=1; ads_prefs="HBESAAA="; auth_multi="1085788904:4e5163b4c574b594b2fc27e5d4cea52b245ac75c|2589485844:654c024c9784be0278cfd1bdf239bd5823f36f19"; auth_token=62e10c62885930c8f82da8dcff78e25cc8b491e6; guest_id_ads=v1%3A173773467856244697; guest_id_marketing=v1%3A173773467856244697; guest_id=v1%3A173773467856244697; twid=u%3D1548369007631167491; ct0=2ce4502036c190bb4c49f760ec9432894b86d91e31049a2da5fbf72815585a9f9e529d3bcfcdb574f772fdfe977747e18af35527173b0a89fe3e3cbd7a1efe0351278fb52dec9eb782ce5dde0fab8339; personalization_id="v1_n8Sa+5mqR5JrxGTmsIyrcg=="',
    "origin": "https://x.com",
    "referer": "https://x.com/IronDiscipline_/status/1870772076635881836",
    "sec-ch-ua": '"Google Chrome";v="131", "Chromium";v="131", "Not_A Brand";v="24"',
    "sec-ch-ua-mobile": "?0",
    "sec-ch-ua-platform": '"macOS"',
    "user-agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36",
    "x-client-transaction-id": "92NYiYT4K1B11QBogXzEuW1YzYP7kv+2HCnPl9OGiQRoUWRcuPdLBN+JZGOiqSx3Lhehs/SetYUz4LftRrYq0zvjX19O9A",
    "x-csrf-token": "2ce4502036c190bb4c49f760ec9432894b86d91e31049a2da5fbf72815585a9f9e529d3bcfcdb574f772fdfe977747e18af35527173b0a89fe3e3cbd7a1efe0351278fb52dec9eb782ce5dde0fab8339",
    "x-twitter-active-user": "yes",
    "x-twitter-auth-type": "OAuth2Session",
    "x-twitter-client-language": "en",
}

# Payload template
payload_template = {
    "variables": {
        "tweet_text": "",
        "reply": {
            "in_reply_to_tweet_id": "",
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

# Function to post tweets
def post_tweets_for_ids(tweet_ids, n, delay_seconds):
    for tweet_id in tweet_ids:
        print(f"Posting tweets for in_reply_to_tweet_id: {tweet_id}")
        for i in range(1, n + 1):
            # Update the tweet_text and in_reply_to_tweet_id for each iteration
            payload_template["variables"]["tweet_text"] = f"{i}. nice humuor"
            payload_template["variables"]["reply"]["in_reply_to_tweet_id"] = tweet_id
            # Convert payload to JSON
            payload = json.dumps(payload_template)

            # Make the POST request
            response = requests.post(url, headers=headers, data=payload)

            if response.status_code == 200:
                print(f"Tweet {i} for tweet ID {tweet_id} posted successfully!")
            else:
                print(f"Failed to post tweet {i} for tweet ID {tweet_id}. Response: {response.text}")
                break  # Stop if there's an error
            time.sleep(delay_seconds)

# Array of tweet IDs to reply to
tweet_ids = [ "1872661240490996130"]

# Number of tweets per tweet ID
n = 10000

# Time delay in seconds
delay_seconds = 10

post_tweets_for_ids(tweet_ids, n, delay_seconds)
