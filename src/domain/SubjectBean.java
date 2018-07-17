package domain;

public class SubjectBean {
	private String subSeq, subName;

	public String getSubSeq() {
		return subSeq;
	}

	public void setSubSeq(String subSeq) {
		this.subSeq = subSeq;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	@Override
	public String toString() {
		return "SubjectBean [subSeq=" + subSeq + ", subName=" + subName + ", toString()=" + super.toString() + "]";
	}
	
}
