package com.hsy.springboot.oauth.server.service;

import com.hsy.springboot.oauth.server.bean.ClientDetailBean;
import com.hsy.springboot.oauth.server.utils.Oauth2Constant;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service(value = "clientDetailsService")
public class ClientDetailsServiceImpl implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientDetailBean clientDetailBean = new ClientDetailBean();
        if(true){
            clientDetailBean.setClientId(clientId);
            clientDetailBean.getAuthorizedGrantTypes(
                    new HashSet<String>(Collections.emptySet()
                            Oauth2Constant.GRANT_TYPE_CLIENT));
        }
        return null;
    }
}
