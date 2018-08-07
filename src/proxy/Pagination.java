package proxy;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class Pagination implements Proxy {
	int pageNumber, pageSize, blockSize, pageCount, rowCount, blockCount, beginRow, endRow, beginPage, endPage, prevBlock, nextBlock;
	boolean existPrev, existNext;

	@Override
	public Map<?, ?> carryOut(Map<?, ?> param) {
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", String.valueOf(beginRow));
		map.put("endRow", String.valueOf(endRow));
		return map;
	}
}
