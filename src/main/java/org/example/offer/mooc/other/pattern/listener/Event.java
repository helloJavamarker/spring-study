package org.example.offer.mooc.other.pattern.listener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private String type; //枚举更合理
}
