package ru.kembrij.smarthomeapi.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.kembrij.smarthomeapi.dto.UserDTO;
import ru.kembrij.smarthomeapi.model.entity.User;
import ru.kembrij.smarthomeapi.util.TimeUtil;

@Component
public class UserMapper implements Mapper {

    public void init(ModelMapper modelMapper) {
        modelMapper.createTypeMap(User.class, UserDTO.class)
                .setConverter(mappingContext -> {
                    var user = mappingContext.getSource();
                    return new UserDTO(
                            user.getId(),
                            user.getFirstname(),
                            user.getLastname(),
                            user.getNickname(),
                            user.getEmail(),
                            user.getNumberphone(),
                            user.getRole()
                            );
                });
    }

}
