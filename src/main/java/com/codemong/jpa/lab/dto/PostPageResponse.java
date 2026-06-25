package com.codemong.jpa.lab.dto;

import java.util.List;
import org.springframework.data.domain.Page;

public record PostPageResponse<T>(List<T> content, int page, int size, long totalElements) {
    public static <T> PostPageResponse<T> from(Page<T> page) {
        return new PostPageResponse<>(page.getContent(), page.getNumber(), page.getSize(), page.getTotalElements());
    }
}
