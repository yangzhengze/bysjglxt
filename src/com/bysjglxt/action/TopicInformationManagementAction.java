package com.bysjglxt.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.bysjglxt.domain.DO.bysjglxt_teacher_user;
import com.bysjglxt.domain.DTO.TeacherInformationDTO;
import com.bysjglxt.domain.DTO.TopicInformationManagementDTO;
import com.bysjglxt.domain.VO.TopicInformationManagementVO;
import com.bysjglxt.service.TopicInformationManagementService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TopicInformationManagementAction extends ActionSupport
		implements ServletResponseAware, ServletRequestAware {
	/*
	 * 
	 */
	private TopicInformationManagementService topicInformationManagementService;

	private HttpServletResponse http_response;

	private HttpServletRequest http_request;

	/*
	 * 
	 */
	private TopicInformationManagementDTO topicInformationManagementDTO;

	private TopicInformationManagementVO topicInformationManagementVO;

	/**
	 * 创建新的课题
	 * 
	 * @throws IOException
	 */
	public void CreateTopic() throws IOException {

		topicInformationManagementDTO.setTeacherInformationDTO(new TeacherInformationDTO());
		topicInformationManagementDTO.getTeacherInformationDTO().setBysjglxtTeacherUser(new bysjglxt_teacher_user());

		if (ActionContext.getContext().getSession().get("userTeacherDTO") != null) {
			TeacherInformationDTO userTeacherDTO = (TeacherInformationDTO) ActionContext.getContext().getSession()
					.get("userTeacherDTO");
			topicInformationManagementDTO.getTeacherInformationDTO().getBysjglxtTeacherUser()
					.setUser_teacher_id(userTeacherDTO.getBysjglxtTeacherUser().getUser_teacher_id());
		} else {
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("登录状态已失效");
			System.out.println("登录状态已失效");
			return;
		}

		topicInformationManagementService.CreateTopic(topicInformationManagementDTO);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("success");

	}

	public void ListTopicByPageAndSearch() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(
				gson.toJson(topicInformationManagementService.VO_Topic_By_PageAndSearch(topicInformationManagementVO)));
	}

	/**
	 * @说明 跳转列表页
	 * 
	 * @return
	 */
	public String TopicListPage() {

		return "TopicListPage";
	}

	/**
	 * @说明 跳转创建课题页
	 * 
	 * @return
	 */
	public String CreateTopicPage() {
		return "CreateTopicPage";
	}

	/*
	 * 
	 */
	@Override
	public void setServletRequest(HttpServletRequest http_request) {

		this.http_request = http_request;

	}

	@Override
	public void setServletResponse(HttpServletResponse http_response) {

		this.http_response = http_response;

	}

	public HttpServletResponse getHttp_response() {
		return http_response;
	}

	public void setHttp_response(HttpServletResponse http_response) {
		this.http_response = http_response;
	}

	public HttpServletRequest getHttp_request() {
		return http_request;
	}

	public void setHttp_request(HttpServletRequest http_request) {
		this.http_request = http_request;
	}

	public TopicInformationManagementDTO getTopicInformationDTO() {
		return topicInformationManagementDTO;
	}

	public void setTopicInformationDTO(TopicInformationManagementDTO topicInformationDTO) {
		this.topicInformationManagementDTO = topicInformationDTO;
	}

	public TopicInformationManagementService getTopicInformationManagementService() {
		return topicInformationManagementService;
	}

	public void setTopicInformationManagementService(
			TopicInformationManagementService topicInformationManagementService) {
		this.topicInformationManagementService = topicInformationManagementService;
	}

	public TopicInformationManagementDTO getTopicInformationManagementDTO() {
		return topicInformationManagementDTO;
	}

	public void setTopicInformationManagementDTO(TopicInformationManagementDTO topicInformationManagementDTO) {
		this.topicInformationManagementDTO = topicInformationManagementDTO;
	}

	public TopicInformationManagementVO getTopicInformationManagementVO() {
		return topicInformationManagementVO;
	}

	public void setTopicInformationManagementVO(TopicInformationManagementVO topicInformationManagementVO) {
		this.topicInformationManagementVO = topicInformationManagementVO;
	}

}