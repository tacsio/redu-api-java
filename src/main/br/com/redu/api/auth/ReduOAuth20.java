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

		String authorizationUrl = String.format(ReduConf.getInstance()
				.getAuthUrl(), config.getApiKey());

		if (!config.getCallback().isEmpty() || config.hasScope()) {
			authorizationUrl += "?";
		}

		if (!config.getCallback().isEmpty()) {
			authorizationUrl = authorizationUrl + "redirect_uri="
					+ OAuthEncoder.encode(config.getCallback());
			if (config.hasScope()) {
				authorizationUrl += "&";
			}
		}

		if (config.hasScope()) {
			authorizationUrl = authorizationUrl + "scope="
					+ OAuthEncoder.encode(config.getScope());
		}

		return authorizationUrl;
	}

	@Override
	public AccessTokenExtractor getAccessTokenExtractor() {
		return new JsonTokenExtractor();
	}
}
