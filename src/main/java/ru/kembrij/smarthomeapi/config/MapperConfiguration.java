package ru.kembrij.smarthomeapi.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kembrij.smarthomeapi.mappers.Mapper;

import java.util.List;

@Configuration
public class MapperConfiguration {

    @Bean
    public ModelMapper modelMapper(List<Mapper> mappers) {
        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true);

        mappers.forEach(m -> m.init(modelMapper));

        return modelMapper;
    }
    @Bean
    public JsonMapper jsonMapper() {
        return new JsonMapper();
    }

    @Bean
    public ObjectMapper objectMapper(ObjectMapper objectMapper) {
        return objectMapper.registerModule(new JavaTimeModule());
    }
}
