package com.bysjglxt.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bysjglxt.dao.GraduationProjectManagementDao;
import com.bysjglxt.domain.DO.bysjglxt_defence;
import com.bysjglxt.domain.DO.bysjglxt_evaluate_review;
import com.bysjglxt.domain.DO.bysjglxt_evaluate_tutor;
import com.bysjglxt.domain.DO.bysjglxt_examination_formal;
import com.bysjglxt.domain.DO.bysjglxt_record_progress;
import com.bysjglxt.domain.DO.bysjglxt_report_opening;
import com.bysjglxt.domain.DO.bysjglxt_summary;
import com.bysjglxt.domain.DO.bysjglxt_taskbook;

public class GraduationProjectManagementDaoImpl implements GraduationProjectManagementDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public int fillEmptyInTaskBook(bysjglxt_taskbook bysjglxt_taskbook) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_taskbook);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyInOpening(bysjglxt_report_opening bysjglxt_report_opening) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_report_opening);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyInProgressEarlystage(bysjglxt_record_progress bysjglxt_record_progressEarlystage) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_record_progressEarlystage);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyInSummary(bysjglxt_summary bysjglxt_summary) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_summary);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyInExaminationFormal(bysjglxt_examination_formal bysjglxt_examination_formal) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_examination_formal);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyInEvaluateTutor(bysjglxt_evaluate_tutor bysjglxt_evaluate_tutor) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_evaluate_tutor);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyEvaluateReview(bysjglxt_evaluate_review bysjglxt_evaluate_review) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_evaluate_review);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int fillEmptyDefence(bysjglxt_defence bysjglxt_defence) {
		int flag = 1;
		try {
			Session session = getSession();
			session.saveOrUpdate(bysjglxt_defence);
		} catch (Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public bysjglxt_taskbook getTaskbookById(String taskbook_id) {
		bysjglxt_taskbook bysjglxt_taskbook = new bysjglxt_taskbook();
		Session session = getSession();
		String hql = "from bysjglxt_taskbook where taskbook_id = '" + taskbook_id + "'";
		Query query = session.createQuery(hql);
		bysjglxt_taskbook = (bysjglxt_taskbook) query.list();
		return bysjglxt_taskbook;
	}

	@Override
	public bysjglxt_report_opening getReportOpening(String report_opening_id) {
		bysjglxt_report_opening bysjglxt_report_opening = new bysjglxt_report_opening();
		Session session = getSession();
		String hql = "from bysjglxt_report_opening where report_opening_id = '" + report_opening_id + "'";
		Query query = session.createQuery(hql);
		bysjglxt_report_opening = (bysjglxt_report_opening) query.list();
		return bysjglxt_report_opening;
	}

	@Override
	public bysjglxt_record_progress getRecordProgress(String record_progress_id) {
		bysjglxt_record_progress bysjglxt_record_progress = new bysjglxt_record_progress();
		Session session = getSession();
		String hql = "from bysjglxt_record_progress where report_opening_id = '" + record_progress_id + "'";
		Query query = session.createQuery(hql);
		bysjglxt_record_progress = (bysjglxt_record_progress) query.list();
		return bysjglxt_record_progress;
	}

	@Override
	public bysjglxt_record_progress findRecordProgressByuserIdAndStage(String report_opening_student, String string) {
		bysjglxt_record_progress bysjglxt_record_progress = new bysjglxt_record_progress();
		Session session = getSession();
		String hql = "from bysjglxt_record_progress where record_progress _student='" + report_opening_student
				+ "' and record_progress _stage='" + string + "'";
		Query query = session.createQuery(hql);
		bysjglxt_record_progress = (bysjglxt_record_progress) query.list();
		return bysjglxt_record_progress;
	}

}
