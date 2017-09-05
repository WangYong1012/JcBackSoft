package com.brave.feature.service;

import com.brave.feature.mapper.company.CompanyMapper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class CompanyService
{
    private CompanyMapper writeMapper;
    private CompanyMapper readMapper;

    @Resource(name="sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession)
    {
        this.writeMapper = ((CompanyMapper)sqlSession.getMapper(CompanyMapper.class));
    }

    @Resource(name="sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession)
    {
        this.readMapper = ((CompanyMapper)sqlSession.getMapper(CompanyMapper.class));
    }

    public List<Map<String, Object>> selectCompanyCity()
    {
        return this.readMapper.selectCompanyCity();
    }

    public List<Map<String, Object>> selectCompanyByCity()
    {
        return this.readMapper.selectCompanyByCity();
    }

    public List<Map<String, Object>> selectCompanyCountByCity(String city)
    {
        return this.readMapper.selectCompanyCountByCity(city);
    }

    public List<Map<String, Object>> selectMountCompany(Map<String, Object> param)
    {
        return this.readMapper.selectMountCompany(param);
    }

    public List<Map<String, Object>> selectRelationCompany(Map<String, Object> param)
    {
        return this.readMapper.selectRelationCompany(param);
    }

    public List<Map<String, Object>> selectCompanyById(Map<String, Object> param)
    {
        return this.readMapper.selectCompanyById(param);
    }

    public List<Map<String, Object>> selectCompanyNumByCity(String city)
    {
        return this.readMapper.selectCompanyNumByCity(city);
    }

    public List<Map<String, Object>> selectCompanyDataByPage(Map<String, Object> param)
    {
        return this.readMapper.selectCompanyDataByPage(param);
    }

    public List<Map<String, Object>> selectRelationCompanyByCity(Map<String, Object> param)
    {
        return this.readMapper.selectRelationCompanyByCity(param);
    }

    public int insertRelationCompany(Map<String, Object> param)
    {
        return this.writeMapper.insertRelationCompany(param);
    }

    public int updateCompanyPurchaseMount(Map<String, Object> param)
    {
        return this.writeMapper.updateCompanyPurchaseMount(param);
    }
}
