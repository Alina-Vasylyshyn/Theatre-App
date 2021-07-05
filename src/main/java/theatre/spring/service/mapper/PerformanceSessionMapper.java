package theatre.spring.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import theatre.spring.dto.request.PerformanceSessionDto;
import theatre.spring.dto.response.PerformanceSessionResponseDto;
import theatre.spring.model.PerformanceSession;
import theatre.spring.service.PerformanceService;
import theatre.spring.service.TheatreStageService;
import theatre.spring.util.DateTimePatternUtil;

@Component
public class PerformanceSessionMapper implements RequestDtoMapper<PerformanceSessionDto,
        PerformanceSession>,
        ResponseDtoMapper<PerformanceSessionResponseDto, PerformanceSession> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final TheatreStageService cinemaHallService;
    private final PerformanceService movieService;

    public PerformanceSessionMapper(TheatreStageService cinemaHallService,
                                    PerformanceService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    @Override
    public PerformanceSession mapToModel(PerformanceSessionDto dto) {
        PerformanceSession movieSession = new PerformanceSession();
        movieSession.setPerformance(movieService.get(dto.getPerformanceId()));
        movieSession.setTheatreStage(cinemaHallService.get(dto.getTheatreStageId()));
        movieSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        return movieSession;
    }

    @Override
    public PerformanceSessionResponseDto mapToDto(PerformanceSession movieSession) {
        PerformanceSessionResponseDto responseDto = new PerformanceSessionResponseDto();
        responseDto.setPerformanceSessionId(movieSession.getId());
        responseDto.setTheatreStageId(movieSession.getTheatreStage().getId());
        responseDto.setPerformanceId(movieSession.getPerformance().getId());
        responseDto.setPerformanceTitle(movieSession.getPerformance().getTitle());
        responseDto.setShowTime(movieSession.getShowTime().format(formatter));
        return responseDto;
    }
}
