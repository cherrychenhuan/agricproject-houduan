package com.agric.myagric.service;

import com.agric.myagric.pojo.*;

import java.util.List;

public interface ArgomanageService {
    List<Agromanagement> getArgomanagelist();

    List<Cropcalendar> getCropCalendarList(Integer argomid,Integer flag);

    List<TimeeventIrrigate> getTimeEventIrriData(Integer cropcalendarid);

    void updateTimeIrrigate(TimeeventIrrigate timeeventIrrigate);

    Integer getMaxTiId();

    void addTimeIrrigate(TimeeventIrrigate timeeventIrrigate);

    void deleteTi(Long id);

    List<StateeventIrrigate> getStateEventIrriData(Integer cropcalendarid);

    Integer getMaxSiId();

    void updateStateIrrigate(StateeventIrrigate stateeventIrrigate);

    void addStateIrrigate(StateeventIrrigate stateeventIrrigate);

    void deleteSi(Long id);

    List<TimeeventNpk> getTimeEventTnData(Integer cropcalendarid);

    void updateTimeTn(TimeeventNpk timeeventNpk);

    void addTimeTn(TimeeventNpk timeeventNpk);

    Integer getMaxTnId();

    void deleteTn(Long id);

    List<StateeventNpk> getStateEventSnData(Integer cropcalendarid);

    List<TimeeventIrrigate> getXdata11(long timeeventid);

    List<TimeeventNpk> getXdata21(long timeeventid);

    List<StateeventIrrigate> getXdata12(long stateeventid);

    List<StateeventNpk> getXdata22(long stateeventid);

    void updateStateSn(StateeventNpk stateeventNpk);

    void addStateSn(StateeventNpk stateeventNpk);

    Integer getMaxSnId();

    void deleteSn(Long id);

    void deleteTm(Long id);

    Integer getMaxTmId();

    List<TimeeventMowing> getXdata31(long timeeventid);

    void updateTimeTm(TimeeventMowing timeeventMowing);

    void addTimeTm(TimeeventMowing timeeventMowing);

    List<TimeeventMowing> getTimeEventTmData(Integer cropcalendarid);

    List<StateeventMowing> getStateEventSmData(Integer cropcalendarid);

    List<StateeventMowing> getXdata32(long stateeventid);

    void updateStateSm(StateeventMowing stateeventMowing);

    void addStateSm(StateeventMowing stateeventMowing);

    Integer getMaxSmId();

    void deleteSm(Long id);

    void addArgomanage(Integer flag,
                       String managename,
                       String userid,
                       String createtime,
                       String areacode,
                       Double lon,
                       Double lat);

    Integer getArgomanage(String userid, String managename);

    void addCropcalendar(Integer argomid, String plandate, String cropName, String cropStartType, String cropEndType, Integer maxDuration);

    Integer getCropcalendar(Integer argomid);

    List<Agromanagement> getAgromanagementById(long mid);

    void updateAgro(Agromanagement agromanagement);

    void addAgro(Agromanagement agromanagement);

    Integer getMaxArgoID();

    void deleteArgo(Integer mid);

    Integer getMaxCalId(Integer mid);

    List<Cropcalendar> getCropcalendarById(long cropCalendarid);

    void upDateCropCalendar(Cropcalendar cropcalendar);

    void addCropCalendar(Cropcalendar cropcalendar);

    void deleteCropcalendar(Integer id);

    List<Agromanagement> getArgomanagelist1();
}
