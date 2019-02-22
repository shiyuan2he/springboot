package com.hsy.springboot.oauth.server.bean;

import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ClientDetailBean implements ClientDetails{
    @Setter
    private String clientId;
    @Setter
    private Set<String> resourceIds;
    @Setter
    private boolean isSecretRequired;
    @Setter
    private String clientSecret;
    @Setter
    private boolean isScoped;
    @Setter
    private Set<String> scope;
    @Setter
    private Set<String> authorizedGrantTypes;
    @Setter
    private Set<String> registeredRedirectUri;
    @Setter
    private Integer accessTokenValiditySeconds;
    @Setter
    private Integer refreshTokenValiditySeconds;
    @Setter
    private Boolean isAutoApprove;
    @Setter
    private Map<String, Object> additionalInformation;
    @Setter
    private Collection<GrantedAuthority> authorities;

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return this.resourceIds;
    }

    @Override
    public boolean isSecretRequired() {
        return isSecretRequired;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public boolean isScoped() {
        return isScoped;
    }

    @Override
    public Set<String> getScope() {
        return scope;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return registeredRedirectUri;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return isAutoApprove;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return additionalInformation;
    }
}
