package com.umc.storeandmission.domain.mission.converter;

import com.umc.storeandmission.domain.mission.dto.MissionResDTO;
import com.umc.storeandmission.domain.mission.entity.Mission;

import java.util.List;

public class MissionConverter {
    public static MissionResDTO.GetInfo toGetInfo(
            Mission mission
    ) {
        return MissionResDTO.GetInfo.builder()
                .storeId(mission.getStore().getStoreId())
                .storeName(mission.getStore().getName())
                .content(mission.getContent())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }

    public static <T> MissionResDTO.Pagination<T> toPagination(
            List<T> data,
            Integer page,
            Integer size
    ) {
        return MissionResDTO.Pagination.<T>builder()
                .data(data)
                .page(page)
                .size(size)
                .build();
    }
}
