package com.festival.domain.info.festivalPub.data.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.festival.domain.info.festivalPub.data.entity.pub.FestivalPub;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PubResponse {

    private Long pubId;
    private String title;
    private String content;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private String filePath;

    private List<String> subFilePath;

    @Builder
    @QueryProjection
    public PubResponse(Long pubId, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate, String filePath, List<String> subFilePath) {
        this.pubId = pubId;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.filePath = filePath;
        this.subFilePath = subFilePath;
    }

    public static PubResponse of(final FestivalPub pub, List<String> subFilePath) {
        return PubResponse.builder()
                .pubId(pub.getId())
                .title(pub.getTitle())
                .content(pub.getContent())
                .createdDate(pub.getCreatedDate())
                .modifiedDate(pub.getModifiedDate())
                .filePath(pub.getPubImage().getMainFilePath())
                .subFilePath(pub.getPubImage().getSubFilePaths() != null ? subFilePath : null)
                .build();
    }
}
