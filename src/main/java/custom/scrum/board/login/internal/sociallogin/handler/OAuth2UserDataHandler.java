package custom.scrum.board.login.internal.sociallogin.handler;

public interface OAuth2UserDataHandler {
    String getFirstName(OAuth2UserData oAuth2UserData);

    String getLastName(OAuth2UserData oAuth2UserData);

    String getEmail(OAuth2UserData oAuth2UserData);
}
