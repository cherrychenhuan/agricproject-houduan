package com.agric.myagric.mapper;

import com.agric.myagric.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArgomanageMapper {

    @Select("select *,mid as id,managename as label from Agromanagement where flag=0")
    List<Agromanagement> getArgomanagelist0();

    @Select("select a.*,b.category from cropcalendar a left join crop_categories b on a.crop_name=b.cropname where argomid=#{argomid}")
    List<Cropcalendar> getCropCalendarList(Integer argomid);

    @Select("select a.*,b.category from cropcalendar a left join crop_categories b on a.crop_name=b.cropname where argomid=#{argomid} and crop_end_date<=CURDATE()")
    List<Cropcalendar> getCropCalendarList1(Integer argomid);

    @Select("select * from timeevent_irrigate where cropcalendarid=#{cropcalendarid}")
    List<TimeeventIrrigate> getTimeEventIrriData(Integer cropcalendarid);

    @Update("update timeevent_irrigate set date=#{date},irrigation_amount=#{irrigationAmount} where timeeventid=#{timeeventid}")
    void updateTimeIrrigate(TimeeventIrrigate timeeventIrrigate);

    @Select("select max(timeeventid) from timeevent_irrigate")
    Integer getMaxTiId();

    @Insert("insert into timeevent_irrigate(cropcalendarid,date,irrigation_amount)values(#{cropCalendarid},#{date},#{irrigationAmount})")
    void addTimeIrrigate(TimeeventIrrigate timeeventIrrigate);

    @Select("select * from timeevent_irrigate where timeeventid=#{timeeventid}")
    List<TimeeventIrrigate> getXdata11(long timeeventid);

    @Delete("delete from timeevent_irrigate where timeeventid=#{id}")
    void deleteTi(Long id);

    @Select("select * from stateevent_irrigate where cropcalendarid=#{cropcalendarid}")
    List<StateeventIrrigate> getStateEventIrriData(Integer cropcalendarid);

    @Select("select max(stateeventid) from stateevent_irrigate")
    Integer getMaxSiId();

    @Update("update stateevent_irrigate set event_state=#{eventState},zero_condition=#{zeroCondition},statenum=#{statenum},irrigation_amount=#{irrigationAmount} where stateeventid=#{stateeventid}")
    void updateStateIrrigate(StateeventIrrigate stateeventIrrigate);
    @Insert("insert into stateevent_irrigate(cropcalendarid,event_state,zero_condition,statenum,irrigation_amount)values(#{cropCalendarid},#{eventState},#{zeroCondition},#{statenum},#{irrigationAmount})")
    void addStateIrrigate(StateeventIrrigate stateeventIrrigate);

    @Delete("delete from stateevent_irrigate where stateeventid=#{id}")
    void deleteSi(Long id);

    @Select("select * from timeevent_npk where cropcalendarid=#{cropcalendarid}")
    List<TimeeventNpk> getTimeEventTnData(Integer cropcalendarid);

    @Select("select * from timeevent_npk where timeeventid=#{id}")
    List<TimeeventNpk> getXdata21(long id);
    @Select("select * from stateevent_npk where stateeventid=#{id}")
    List<StateeventNpk> getXdata22(long id);

    @Update("update timeevent_npk set date=#{date},n_amount=#{nAmount} ,p_amount=#{nAmount},k_amount=#{nAmount},n_recovery=#{nRecovery} ,p_recovery=#{pRecovery},k_recovery=#{kRecovery} where timeeventid=#{timeeventid}")
    void updateTimeTn(TimeeventNpk timeeventNpk);

    @Insert("insert into timeevent_npk(cropcalendarid,date,n_amount,p_amount,k_amount,n_recovery,p_recovery,k_recovery)values(#{cropCalendarid},#{date},#{nAmount} ,#{pAmount},#{kAmount},#{nRecovery} ,#{pRecovery},#{kRecovery})")
    void addTimeTn(TimeeventNpk timeeventNpk);

    @Select("select max(timeeventid) from timeevent_npk")
    Integer getMaxTnId();

    @Delete("delete from timeevent_npk where timeeventid=#{id}")
    void deleteTn(Long id);

    @Select("select * from stateevent_npk where cropcalendarid=#{cropcalendarid}")
    List<StateeventNpk> getStateEventSnData(Integer cropcalendarid);

    @Select("select * from stateevent_irrigate where stateeventid=#{stateeventid}")
    List<StateeventIrrigate> getXdata12(long stateeventid);

    @Update("update stateevent_npk set event_state=#{eventState},zero_condition=#{zeroCondition},statenum=#{statenum},n_amount=#{nAmount} ,p_amount=#{nAmount},k_amount=#{nAmount},n_recovery=#{nRecovery} ,p_recovery=#{pRecovery},k_recovery=#{kRecovery} where stateeventid=#{stateeventid}")
    void updateStateSn(StateeventNpk stateeventNpk);

    @Insert("insert into stateevent_npk(cropcalendarid,event_state,zero_condition,statenum,n_amount,p_amount,k_amount,n_recovery,p_recovery,k_recovery)values(#{cropCalendarid},#{eventState},#{zeroCondition},#{statenum},#{nAmount},#{pAmount},#{kAmount},#{nRecovery} ,#{pRecovery},#{kRecovery})")
    void addStateSn(StateeventNpk stateeventNpk);

    @Select("select max(stateeventid) from stateevent_npk")
    Integer getMaxSnId();

    @Delete("delete from stateevent_npk where stateeventid=#{id}")
    void deleteSn(Long id);

    @Select("select * from timeevent_mowing where cropcalendarid=#{cropcalendarid}")
    List<TimeeventMowing> getTimeEventTmData(Integer cropcalendarid);

    @Insert("insert into timeevent_mowing(cropcalendarid,date,biomass_remaining)values(#{cropCalendarid},#{date},#{biomassRemaining})")
    void addTimeTm(TimeeventMowing timeeventMowing);

    @Update("update timeevent_mowing set date=#{date},biomass_remaining=#{biomassRemaining} where timeeventid=#{timeeventid}")
    void updateTimeTm(TimeeventMowing timeeventMowing);

    @Select("select * from timeevent_mowing where timeeventid=#{timeeventid}")
    List<TimeeventMowing> getXdata31(long timeeventid);
    @Select("select max(timeeventid) from timeevent_mowing")
    Integer getMaxTmId();

    @Delete("delete from timeevent_mowing where timeeventid=#{id}")
    void deleteTm(Long id);

    @Select("select * from stateevent_mowing where cropcalendarid=#{cropcalendarid}")
    List<StateeventMowing> getStateEventSmData(Integer cropcalendarid);

    @Select("select * from stateevent_mowing where stateeventid=#{stateeventid}")
    List<StateeventMowing> getXdata32(long stateeventid);

    @Update("update stateevent_mowing set event_state=#{eventState},zero_condition=#{zeroCondition},statenum=#{statenum},biomass_remaining=#{biomassRemaining} where stateeventid=#{stateeventid}")
    void updateStateSm(StateeventMowing stateeventMowing);

    @Insert("insert into stateevent_mowing (cropcalendarid,event_state,zero_condition,statenum,biomass_remaining)values(#{cropCalendarid},#{eventState},#{zeroCondition},#{statenum},#{biomassRemaining})")
    void addStateSm(StateeventMowing stateeventMowing);

    @Select("select max(stateeventid) from stateevent_mowing")
    Integer getMaxSmId();

    @Delete("delete from stateevent_mowing where stateeventid=#{id}")
    void deleteSm(Long id);

    @Insert("insert into agromanagement (flag,managename,userid,createtime,areacode,lon,lat)values(#{flag},#{managename},#{userid},#{createtime},#{areacode},#{lon},#{lat})")
    void addArgomanage(Integer flag, String managename, String userid, String createtime, String areacode, Double lon, Double lat);

    @Select("select mid from agromanagement where userid=#{userid} and managename=#{managename}")
    Integer getArgomanage(String userid, String managename);

    @Insert("insert into cropcalendar (argomid,plandate,crop_name,crop_start_type,crop_end_type,max_duration)values(#{argomid},#{plandate},#{cropName},#{cropStartType},#{cropEndType},#{maxDuration})")
    void addCropcalendar(Integer argomid, String plandate, String cropName, String cropStartType, String cropEndType, Integer maxDuration);

    @Select("select cropcalendarid from cropcalendar where argomid=#{argomid}")
    Integer getCropcalendar(Integer argomid);

    @Select("select * from agromanagement where mid=#{mid}")
    List<Agromanagement> getAgromanagementById(long mid);

    @Update("update agromanagement set flag=#{flag},managename=#{managename},userid=#{userid},createtime=#{createtime},areacode=#{areacode},lon=#{lon},lat=#{lat} where mid=#{mid}")
    void updateAgro(Agromanagement agromanagement);

    @Insert("insert into agromanagement (flag,managename,userid,createtime,areacode,lon,lat)values(#{flag},#{managename},#{userid},#{createtime},#{areacode},#{lon},#{lat})")
    void addAgro(Agromanagement agromanagement);

    @Select("select max(mid) from agromanagement")
    Integer getMaxArgoID();

    @Delete("delete from agromanagement where mid=#{mid}")
    void deleteArgo(Integer mid);

    @Select("select max(cropcalendarid) from cropcalendar")
    Integer getMaxCalId(Integer mid);

    @Select("select * from Cropcalendar where cropCalendarid=#{cropCalendarid}")
    List<Cropcalendar> getCropcalendarById(long cropCalendarid);


    @Update("update cropcalendar set argomid= #{argomid},plandate=#{plandate},crop_Name=#{cropName},crop_Start_Type=#{cropStartType},crop_End_Type=#{cropEndType},crop_End_Type=#{maxDuration} where cropcalendarid=#{cropCalendarid}")
    void upDateCropCalendar(Cropcalendar cropcalendar);
    @Insert("insert into cropcalendar (argomid,plandate,crop_name,crop_start_type,crop_end_type,max_duration)values(#{argomid},#{plandate},#{cropName},#{cropStartType},#{cropEndType},#{maxDuration})")
    void addCropCalendar(Cropcalendar cropcalendar);

    @Delete("delete from Cropcalendar where cropcalendarid=#{id}")
    void deleteCropcalendar(Integer id);

    @Select("select *,mid as id,managename as label from Agromanagement where flag=1")
    List<Agromanagement> getArgomanagelist1();
}
