package com.alorma.travis.domain;

import java.util.Date;
import java.util.List;

public class TravisPayload {

    private long id;
    private long number;
    private String status;
    private String started_at;
    private String finished_at;
    private String status_message;
    private String commit;
    private String branch;
    private String message;
    private String compare_url;
    private String committer_name;
    private String committer_email;
    private String type;
    private String author_name;
    private String author_email;
    private String build_url;
    private Repository repository;
    private TravisConfig config;
    private List<TravisMatrix> matrix;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStarted_at() {
        return started_at;
    }

    public void setStarted_at(String started_at) {
        this.started_at = started_at;
    }

    public String getFinished_at() {
        return finished_at;
    }

    public void setFinished_at(String finished_at) {
        this.finished_at = finished_at;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCompare_url() {
        return compare_url;
    }

    public void setCompare_url(String compare_url) {
        this.compare_url = compare_url;
    }

    public String getCommitter_name() {
        return committer_name;
    }

    public void setCommitter_name(String committer_name) {
        this.committer_name = committer_name;
    }

    public String getCommitter_email() {
        return committer_email;
    }

    public void setCommitter_email(String committer_email) {
        this.committer_email = committer_email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_email() {
        return author_email;
    }

    public void setAuthor_email(String author_email) {
        this.author_email = author_email;
    }

    public String getBuild_url() {
        return build_url;
    }

    public void setBuild_url(String build_url) {
        this.build_url = build_url;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public TravisConfig getConfig() {
        return config;
    }

    public void setConfig(TravisConfig config) {
        this.config = config;
    }

    public List<TravisMatrix> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<TravisMatrix> matrix) {
        this.matrix = matrix;
    }
}
