package HS_hrs.user_service.Dto;

import HS_hrs.user_service.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserResponseVacationDto {

    private Integer userId;
    private String name;

    public static UserResponseVacationDto fromEntity(User user) {
        return new UserResponseVacationDto(user.getUserId(), user.getUsername());
    }

}