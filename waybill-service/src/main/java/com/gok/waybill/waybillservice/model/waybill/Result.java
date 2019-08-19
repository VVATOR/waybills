package com.gok.waybill.waybillservice.model.waybill;

import com.gok.waybill.waybillservice.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name="result")
public class Result extends Model {
}
