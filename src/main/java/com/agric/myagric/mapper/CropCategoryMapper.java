package com.agric.myagric.mapper;


import com.agric.myagric.pojo.CropEcotypes;
import com.agric.myagric.pojo.CropGenerictypes;
import com.agric.myagric.pojo.CropVarities;
import com.agric.myagric.pojo.Cropcategories;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CropCategoryMapper {


    @Delete("delete from crop_categories where id=#{id}")
    void delete(Integer id);

    @Insert("insert into crop_categories values(#{id},#{cropname},#{englishname},#{category},#{family},#{genus},#{phenotype},#{cultivationType},#{distribution},#{cropusage},#{remark},#{imgNum})")
    void add(Cropcategories cropcategory);

    @Select("select *,cropname as label  from crop_categories")
    List<Cropcategories> list();

    @Select("select max(id)+1 from crop_categories where category= #{category}")
    Integer getNewID(String category);

    @Select("select DISTINCT genus from crop_categories where family =#{family}")
    List<String> getGenusList(String family);

    @Select("select count(*) as rownum FROM crop_categories where id<=#{id} order by id;")
    Integer getRowNum(Integer id);

    @Update("update crop_categories set cropname=#{cropname},englishname=#{englishname},category=#{category},family=#{family},genus=#{genus},phenotype=#{phenotype},cultivationType=#{cultivationType},distribution=#{distribution},cropusage=#{cropusage},remark=#{remark},img_num=#{imgNum} " +
            "where id=#{id}")
    void update(Cropcategories cropcategory);

    @Select("select * from crop_categories where id like CONCAT('%', #{value}, '%') or cropname like CONCAT('%', #{value}, '%') or englishname like CONCAT('%', #{value}, '%') or category like CONCAT('%', #{value}, '%')" +
            " or family like CONCAT('%', #{value}, '%') or genus like CONCAT('%', #{value}, '%') or phenotype like CONCAT('%', #{value}, '%') " +
            "or cultivationtype like CONCAT('%', #{value}, '%') or distribution like CONCAT('%', #{value}, '%') or cropusage like CONCAT('%', #{value}, '%')" +
            " or remark like CONCAT('%', #{value}, '%') or img_num like CONCAT('%', #{value}, '%')")
    List<Cropcategories> getSearchFilterList(String value);

    @Select("select * from crop_categories")
    List<Cropcategories> getAllData();



    @Select("select *  from crop_ecotypes where cropid=#{cropid}")
    List<CropEcotypes> getEcotypeList(Integer cropid);

    @Select("select *  from crop_varities where parent=#{ecotype}")
    List<CropVarities> getCropVarietyList(String ecotype);

    @Select("select *  from crop_generictypes where cropid=#{cropid}")
    List<CropGenerictypes> getGenerictypeData(Integer cropid);

    @Select("select * from crop_categories where category=#{category}")
    List<Cropcategories> getCropBycategory(String category);

    @Select("select max(ecotypeid)  from crop_ecotypes where cropid=#{cropid}")
    Integer getNewEcotypeID(Integer cropid);


    @Insert("insert into crop_ecotypes values(#{ecotypeid},#{cropid},#{cropname},#{ecotype},#{parent},#{tbasem},#{teffmx},#{tsumem},#{idsl},#{dlo},#{dlc},#{tsum1},#{tsum2},#{dtsmtb},#{dvsi},#{dvsend},#{vernbase},#{vernsat},#{verndvs},#{vernrtb},#{tdwi},#{rgrlai},#{slatb},#{spa},#{ssatb},#{span},#{tbase},#{kdiftb},#{efftb},#{amaxtb},#{refco2L},#{tmpftb},#{tmnftb},#{cvl},#{cvo},#{cvr},#{cvs},#{q10},#{rml},#{rmo},#{rmr},#{rms},#{rfsetb},#{frtb},#{fltb},#{fstb},#{fotb},#{perdl},#{rdrrtb},#{rdrstb},#{cfet},#{depnr},#{iairdu},#{iox},#{rdi},#{rri},#{rdmcr},#{nmaxlvTb},#{nmaxrtFr},#{nmaxstFr},#{nmaxso},#{ncritFr},#{nresidlv},#{nresidst},#{nresidrt},#{tcnt},#{nfixFr},#{pmaxlvTb},#{pmaxrtFr},#{pmaxstFr},#{pmaxso},#{pcritFr},#{presidlv},#{presidst},#{presidrt},#{tcpt},#{kmaxlvTb},#{kmaxrtFr},#{kmaxstFr},#{kmaxso},#{kcritFr},#{kresidlv},#{kresidst},#{kresidrt},#{tckt},#{dvsNpkStop},#{dvsNpkTransl},#{nlaiNpk},#{nslaNpk},#{npart},#{nlueNpk},#{npkTranslrtFr},#{rdrlvNpk},#{rnuptakemax},#{rpuptakemax},#{rkuptakemax})")
    void addEcotype(CropEcotypes cropEcotypes);

    @Update("update crop_ecotypes set cropid=#{cropid},cropname=#{cropname},ecotype=#{ecotype},parent=#{parent},tbasem=#{tbasem},teffmx=#{teffmx},tsumem=#{tsumem},idsl=#{idsl},dlo=#{dlo},dlc=#{dlc},tsum1=#{tsum1},tsum2=#{tsum2},dtsmtb=#{dtsmtb},dvsi=#{dvsi},dvsend=#{dvsend},vernbase=#{vernbase},vernsat=#{vernsat},verndvs=#{verndvs},vernrtb=#{vernrtb},tdwi=#{tdwi},rgrlai=#{rgrlai},slatb=#{slatb},spa=#{spa},ssatb=#{ssatb},span=#{span},tbase=#{tbase},kdiftb=#{kdiftb},efftb=#{efftb},amaxtb=#{amaxtb},refco2L=#{refco2L},tmpftb=#{tmpftb},tmnftb=#{tmnftb},cvl=#{cvl},cvo=#{cvo},cvr=#{cvr},cvs=#{cvs},q10=#{q10},rml=#{rml},rmo=#{rmo},rmr=#{rmr},rms=#{rms},rfsetb=#{rfsetb},frtb=#{frtb},fltb=#{fltb},fstb=#{fstb},fotb=#{fotb},perdl=#{perdl},rdrrtb=#{rdrrtb},rdrstb=#{rdrstb},cfet=#{cfet},depnr=#{depnr},iairdu=#{iairdu},iox=#{iox},rdi=#{rdi},rri=#{rri},rdmcr=#{rdmcr},nmaxlv_Tb=#{nmaxlvTb},nmaxrt_Fr=#{nmaxrtFr},nmaxst_Fr=#{nmaxstFr},nmaxso=#{nmaxso},ncrit_Fr=#{ncritFr},nresidlv=#{nresidlv},nresidst=#{nresidst},nresidrt=#{nresidrt},tcnt=#{tcnt},nfix_Fr=#{nfixFr},pmaxlv_Tb=#{pmaxlvTb},pmaxrt_Fr=#{pmaxrtFr},pmaxst_Fr=#{pmaxstFr},pmaxso=#{pmaxso},pcrit_Fr=#{pcritFr},presidlv=#{presidlv},presidst=#{presidst},presidrt=#{presidrt},tcpt=#{tcpt},kmaxlv_Tb=#{kmaxlvTb},kmaxrt_Fr=#{kmaxrtFr},kmaxst_Fr=#{kmaxstFr},kmaxso=#{kmaxso},kcrit_Fr=#{kcritFr},kresidlv=#{kresidlv},kresidst=#{kresidst},kresidrt=#{kresidrt},tckt=#{tckt},dvs_Npk_Stop=#{dvsNpkStop},dvs_Npk_Transl=#{dvsNpkTransl},nlai_Npk=#{nlaiNpk},nsla_Npk=#{nslaNpk},npart=#{npart},nlue_Npk=#{nlueNpk},npk_Translrt_Fr=#{npkTranslrtFr},rdrlv_Npk=#{rdrlvNpk},rnuptakemax=#{rnuptakemax},rpuptakemax=#{rpuptakemax},rkuptakemax=#{rkuptakemax} where ecotypeid=#{ecotypeid}")
    void updateEcotype(CropEcotypes cropEcotypes);

    @Select("select max(varietyid)  from crop_varities where parent=#{ecotype}")
    Integer getNewVarietyID(String ecotype);

    @Insert("insert into crop_varities values(#{varietyid},#{cropid},#{cropname},#{variety},#{parent},#{tbasem},#{teffmx},#{tsumem},#{idsl},#{dlo},#{dlc},#{tsum1},#{tsum2},#{dtsmtb},#{dvsi},#{dvsend},#{vernbase},#{vernsat},#{verndvs},#{vernrtb},#{tdwi},#{rgrlai},#{slatb},#{spa},#{ssatb},#{span},#{tbase},#{kdiftb},#{efftb},#{amaxtb},#{refco2L},#{tmpftb},#{tmnftb},#{cvl},#{cvo},#{cvr},#{cvs},#{q10},#{rml},#{rmo},#{rmr},#{rms},#{rfsetb},#{frtb},#{fltb},#{fstb},#{fotb},#{perdl},#{rdrrtb},#{rdrstb},#{cfet},#{depnr},#{iairdu},#{iox},#{rdi},#{rri},#{rdmcr},#{nmaxlvTb},#{nmaxrtFr},#{nmaxstFr},#{nmaxso},#{ncritFr},#{nresidlv},#{nresidst},#{nresidrt},#{tcnt},#{nfixFr},#{pmaxlvTb},#{pmaxrtFr},#{pmaxstFr},#{pmaxso},#{pcritFr},#{presidlv},#{presidst},#{presidrt},#{tcpt},#{kmaxlvTb},#{kmaxrtFr},#{kmaxstFr},#{kmaxso},#{kcritFr},#{kresidlv},#{kresidst},#{kresidrt},#{tckt},#{dvsNpkStop},#{dvsNpkTransl},#{nlaiNpk},#{nslaNpk},#{npart},#{nlueNpk},#{npkTranslrtFr},#{rdrlvNpk},#{rnuptakemax},#{rpuptakemax},#{rkuptakemax})")
    void addVariety(CropVarities cropVarities);

    @Update("update crop_Varities set varietyid=#{varietyid},cropid=#{cropid},cropname=#{cropname},variety=#{variety},parent=#{parent},tbasem=#{tbasem},teffmx=#{teffmx},tsumem=#{tsumem},idsl=#{idsl},dlo=#{dlo},dlc=#{dlc},tsum1=#{tsum1},tsum2=#{tsum2},dtsmtb=#{dtsmtb},dvsi=#{dvsi},dvsend=#{dvsend},vernbase=#{vernbase},vernsat=#{vernsat},verndvs=#{verndvs},vernrtb=#{vernrtb},tdwi=#{tdwi},rgrlai=#{rgrlai},slatb=#{slatb},spa=#{spa},ssatb=#{ssatb},span=#{span},tbase=#{tbase},kdiftb=#{kdiftb},efftb=#{efftb},amaxtb=#{amaxtb},refco2L=#{refco2L},tmpftb=#{tmpftb},tmnftb=#{tmnftb},cvl=#{cvl},cvo=#{cvo},cvr=#{cvr},cvs=#{cvs},q10=#{q10},rml=#{rml},rmo=#{rmo},rmr=#{rmr},rms=#{rms},rfsetb=#{rfsetb},frtb=#{frtb},fltb=#{fltb},fstb=#{fstb},fotb=#{fotb},perdl=#{perdl},rdrrtb=#{rdrrtb},rdrstb=#{rdrstb},cfet=#{cfet},depnr=#{depnr},iairdu=#{iairdu},iox=#{iox},rdi=#{rdi},rri=#{rri},rdmcr=#{rdmcr},nmaxlv_Tb=#{nmaxlvTb},nmaxrt_Fr=#{nmaxrtFr},nmaxst_Fr=#{nmaxstFr},nmaxso=#{nmaxso},ncrit_Fr=#{ncritFr},nresidlv=#{nresidlv},nresidst=#{nresidst},nresidrt=#{nresidrt},tcnt=#{tcnt},nfix_Fr=#{nfixFr},pmaxlv_Tb=#{pmaxlvTb},pmaxrt_Fr=#{pmaxrtFr},pmaxst_Fr=#{pmaxstFr},pmaxso=#{pmaxso},pcrit_Fr=#{pcritFr},presidlv=#{presidlv},presidst=#{presidst},presidrt=#{presidrt},tcpt=#{tcpt},kmaxlv_Tb=#{kmaxlvTb},kmaxrt_Fr=#{kmaxrtFr},kmaxst_Fr=#{kmaxstFr},kmaxso=#{kmaxso},kcrit_Fr=#{kcritFr},kresidlv=#{kresidlv},kresidst=#{kresidst},kresidrt=#{kresidrt},tckt=#{tckt},dvs_Npk_Stop=#{dvsNpkStop},dvs_Npk_Transl=#{dvsNpkTransl},nlai_Npk=#{nlaiNpk},nsla_Npk=#{nslaNpk},npart=#{npart},nlue_Npk=#{nlueNpk},npk_Translrt_Fr=#{npkTranslrtFr},rdrlv_Npk=#{rdrlvNpk},rnuptakemax=#{rnuptakemax},rpuptakemax=#{rpuptakemax},rkuptakemax=#{rkuptakemax} where varietyid=#{varietyid}")
    void updateVariety(CropVarities cropVarities);


    @Delete("delete from crop_ecotypes where ecotypeid=#{ecotypeid} ")
    void deleteEcotype(Integer ecotypeid);

    @Delete("delete from crop_varities where varietyid=#{varietyid} ")
    void deleteVariety(Integer varietyid);

    @Select("select max(replace(genericid,concat(#{id},'G'),'')+0) as mgenericid from crop_generictypes where cropid=#{id}")
    Integer getNewGenericID(Integer id);

    @Insert("insert into crop_Generictypes values(#{cropId},#{cropName},#{genericId},#{genericType},#{co2Efftb},#{co2Tratb},#{co2Amaxtb})")
    void addGenericType(CropGenerictypes cropGenerictypes);

    @Update("update crop_Generictypes set co2Amaxtb=#{co2Amaxtb},co2Efftb=#{co2Efftb},co2Tratb=#{co2Tratb} where genericId=#{genericId}")
    void updateGenericType(CropGenerictypes cropGenerictypes);

    @Delete("delete from crop_Generictypes where genericid=#{genericid} ")
    void deleteGenericType(String genericid);
}
