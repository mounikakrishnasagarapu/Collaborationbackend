package com.niit.collaborationbackend.dao;

import java.util.List;

import com.niit.collaborationbackend.model.ForumComment;

public interface ForumCommentDAO {
	public boolean saveOrUpdate(ForumComment forumcomment);
	public boolean delete(ForumComment forumcomment);
	public List<ForumComment> list(int fid);
}
