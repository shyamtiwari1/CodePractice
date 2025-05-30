# test open api ki api

from openai import OpenAI
OPENAI_API_KEY = "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"
client = OpenAI(api_key=OPENAI_API_KEY)



HASHTAGS = "#zelena #zeudi #helena #helevier #Tommavi #shailenzo #sstvidf #GrandeFratello #MAGA"
def generate_reply(tweet_text):
    """
    Generate a reply for a given tweet using OpenAI's API and append hashtags.
    """
    prompt = f"Reply to the following tweet in a witty and engaging way:\n\n'{tweet_text}'"
    try:
        response = client.completions.create(
        model="gpt-3",
#         engine="text-davinci-003",  # Use GPT-3.5 or similar
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
def main():
    print(generate_reply("Hey there! How are you doing today?"))

if __name__ == "__main__":
    main()