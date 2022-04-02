package com.example.cseeselfcheck.user.config.dto;
import com.example.cseeselfcheck.user.googlelogin.entity.Role;
import com.example.cseeselfcheck.user.googlelogin.entity.UserEntity;
import com.example.cseeselfcheck.user.domain.User;

import lombok.Builder;
import lombok.Getter;
import java.util.Map;
@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String email;
    private final Map<String, Object> attributes;
    private final String nameAttributeKey;
    private final String email;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String email) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.email = email;
    }


    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String,Object> attributes) {
        return OAuthAttributes.builder()
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public UserEntity toEntity() {
        return UserEntity.builder()
                .email(email)
                .role(Role.GUEST)
                .build();
    }
}

    public User toEntity() {
        return User.builder()
                .email(email)
                .build();
    }
}