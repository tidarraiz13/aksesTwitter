import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "ZKX54l7eWQWyvcc1eJ9tiMN4A";
    private final static String CONSUMER_KEY_SECRET = "mN77JjaGV1i8cYveFclN6e4Agd51GXPPWkzQOvsqFQHk4R1ReE";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, im updating status again ");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "nnNRLm3kUjZptDl0jUdKrIVC1tpAzzv90JSA89VlvB5Ek";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1319990359-dqza3Oj2v3pmwDjRsIsruAj4CpJ6XhQLAoMsvR0";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}