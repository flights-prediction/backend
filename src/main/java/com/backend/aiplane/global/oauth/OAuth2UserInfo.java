package com.backend.aiplane.global.oauth;

public interface OAuth2UserInfo {
    String getProviderId();
    String getProvider();
    String getName();
}