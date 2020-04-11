package com.myfin.other;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Properties {
    String application_url;
    String drivers_path;
    String nb_rb_url;
    String test_screenshot_path;
}
