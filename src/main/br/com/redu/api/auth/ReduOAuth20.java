package br.com.redu.api.auth;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Verb;
import org.scribe.utils.OAuthEncoder;

import br.com.redu.api.ReduConf;

public class ReduOAuth20 extends DefaultApi20 {

	@Override
	public Verb getAccessTokenVerb() {
		return Verb.POST;
	}

	@Override
	public String getAccessTokenEndpoint() {
		return ReduConf.getInstance().getAccessTokenUrl();
	}

	@Override
	public String getAuthorizationUrl(OAuthConfig config) {
		if (config.hasScope()) {
			return String.format(ReduConf.getInstance().getAuthUrl(),
					config.getApiKey(),
					OAuthEncoder.encode(config.getCallback()));
		} else {
			return String.format(ReduConf.getInstance().getScopedAuthUrl(),
					config.getApiKey(),
					OAuthEncoder.encode(config.getCallback()));
		}
	}

	@Override
	public AccessTokenExtractor getAccessTokenExtractor() {
		return new JsonTokenExtractor();
	}

}
