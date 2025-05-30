import tweepy

# Replace with your keys and tokens
API_KEY = "Of5k513x2zF5We53OvvIgmGLb"
API_SECRET_KEY = "GfiruajPBVlZg2aAPAMBf2lTRr0dtprqGG10BBKPeBJXbcgSxk"
ACCESS_TOKEN = "1085788904-1SbiP2x4cniiiFGpjRB3GZ3uQFi4zhoe5F5T3I8"
ACCESS_TOKEN_SECRET = "ojUhEzozBEgpqpqi1qnaXnWBHmfDn2Fz9nzqrJj6SIi2d"

# bearer token = 'AAAAAAAAAAAAAAAAAAAAAIGoyQEAAAAApm52KJptndwaZ3b%2BpILZNzurS94%3DAlddhHWbQyzWTIiNIwqPrPzAlkNVptDmG62K3r83KId6w5TQVb'

# Authenticate
auth = tweepy.OAuth1UserHandler(API_KEY, API_SECRET_KEY, ACCESS_TOKEN, ACCESS_TOKEN_SECRET)
api = tweepy.API(auth)

def fetch_tweets(username, count=10):
    try:
        # Fetch tweets
        tweets = api.user_timeline(screen_name=username, count=count, tweet_mode="extended")

        # Print or save the tweets
        for tweet in tweets:
            print(f"{tweet.created_at} - {tweet.full_text}")
    except tweepy.TweepyException as e:
        print(f"Error: {e}")

# Example: Fetch the latest 10 tweets from a specific account
fetch_tweets("IronDiscipline_", count=10)
