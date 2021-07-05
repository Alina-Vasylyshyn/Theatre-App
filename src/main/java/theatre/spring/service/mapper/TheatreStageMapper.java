package theatre.spring.service.mapper;

import org.springframework.stereotype.Component;
import theatre.spring.dto.request.TheatreStageRequestDto;
import theatre.spring.dto.response.TheatreStageResponseDto;
import theatre.spring.model.TheatreStage;

@Component
public class TheatreStageMapper implements RequestDtoMapper<TheatreStageRequestDto, TheatreStage>,
        ResponseDtoMapper<TheatreStageResponseDto, TheatreStage> {
    @Override
    public TheatreStage mapToModel(TheatreStageRequestDto dto) {
        TheatreStage cinemaHall = new TheatreStage();
        cinemaHall.setDescription(dto.getDescription());
        cinemaHall.setCapacity(dto.getCapacity());
        return cinemaHall;
    }

    @Override
    public TheatreStageResponseDto mapToDto(TheatreStage cinemaHall) {
        TheatreStageResponseDto responseDto = new TheatreStageResponseDto();
        responseDto.setId(cinemaHall.getId());
        responseDto.setDescription(cinemaHall.getDescription());
        return responseDto;
    }
}
