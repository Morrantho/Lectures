package com.project.events.repositories;

import com.project.events.models.Comment;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface CommentRepository extends CrudRepository<Comment,Long>{
}
