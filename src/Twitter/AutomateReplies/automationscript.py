

import time
import tweepy
from openai import OpenAI

client = OpenAI(api_key=OPENAI_API_KEY)

# === Step 1: Set Up Your API Keys ===
# Twitter API Keys (Ensure you're using OAuth 2.0 Bearer Token for v2)
TWITTER_BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAIGoyQEAAAAA6FV002lTBisaecQfeW3d%2FurkgKM%3Dx5LVqPmrZeGwqD74H0aClcl8uoIXs1qyjMBzzGmg7T7q3yUFWP"

# OpenAI API Key
# OPENAI_API_KEY = "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"

# List of hashtags to append
HASHTAGS = "#zelena #zeudi #helena #helevier #Tommavi #shailenzo #sstvidf #GrandeFratello #MAGA"

# === Step 2: Authenticate with Twitter API v2 ===
client = tweepy.Client(bearer_token=TWITTER_BEARER_TOKEN)

# Predefined list of usernames
USERNAMES = ["__madhuryaaa", "Harshit20733626", "DearS_o_n"]  # Add your predefined usernames here

# === Step 3: Fetch Tweets ===
def fetch_tweets(username, count=5):
    """
    Fetch the latest tweets from a user using Twitter API v2.
    """
    try:
        # Get the user ID
        user = client.get_user(username=username)
        user_id = user.data.id

        # Fetch tweets from user timeline
        tweets = client.get_users_tweets(id=user_id, max_results=count)
        return tweets.data if tweets.data else []
#     except tweepy.TooManyRequests as e:
#         print("Rate limit exceeded, waiting for 15 minutes...")
#         time.sleep(15 * 60)  # Sleep for 15 minutes
#         return fetch_tweets(username, count)  # Retry fetching tweets after the sleep
    except Exception as e:
        print(f"Error fetching tweets: {e}")
        return []

# === Step 4: Generate Reply Using ChatGPT ===
def generate_reply(tweet_text):
    """
    Generate a reply for a given tweet using OpenAI's API and append hashtags.
    """
    prompt = f"Reply to the following tweet in a witty and engaging way:\n\n'{tweet_text}'"
    try:
        response = client.completions.create(engine="text-davinci-003",  # Use GPT-3.5 or similar
        prompt=prompt,
        max_tokens=100,
        n=1,
        stop=None,
        temperature=0.7)
        reply = response.choices[0].text.strip()
        # Append hashtags to the reply
        return f"{reply} {HASHTAGS}"
    except Exception as e:
        print(f"Error generating reply: {e}")
        return f"Sorry, I couldn't think of a response! {HASHTAGS}"

# === Step 5: Post Replies ===
def post_reply(tweet_id, reply_text):
    """
    Post a reply to a specific tweet using Twitter API v2.
    """
    try:
        # Post reply using Twitter API v2
        client.create_tweet(
            text=reply_text,
            in_reply_to_tweet_id=tweet_id
        )
        print(f"Replied to tweet ID {tweet_id}: {reply_text}")
    except Exception as e:
        print(f"Error posting reply: {e}")

# === Step 6: Main Script ===
def main():
    # Iterate over predefined usernames
    for username in USERNAMES:
        print(f"Processing tweets for {username}...")

        tweets = ["1"] #fetch_tweets(username, count=5)
#
#         if not tweets:
#             print(f"No tweets found for {username}.")
#             continue

        for tweet in tweets:
            tweet_id = "1882823324537078119"
            tweet_text = "hey man whats up how are you doing today?"
            print(f"Tweet: {tweet_text}")

            # Generate a reply
            reply = generate_reply(tweet_text)
            print(f"Reply: {reply}")

            # Post the reply
            post_reply(tweet_id, reply)

if __name__ == "__main__":
    main()
