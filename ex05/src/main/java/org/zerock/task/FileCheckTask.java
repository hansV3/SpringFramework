package org.zerock.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.zerock.domain.BoardAttachVO;
import org.zerock.mapper.BoardAttachMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component //해당 클래스는 스프링 컨테이너에 의해 관리되는 빈으로 등록되며
		   //다른 빈과의 의존성 주입이나 컴포넌트 검색 등의 스프링 기능을 사용할 수 있습니다.
public class FileCheckTask {
	
	
	@Setter(onMethod_ = { @Autowired })
	private BoardAttachMapper attachMapper;
	
	private String getFolderYesterDay() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, -1);
		
		String str = sdf.format(cal.getTime());
		
		//return str.replace("-", File.separator);
		return str;
	}
	
	@Scheduled(cron = "0 0 2 * * *") //매일 새벽 2시 동작
	//@Scheduled(cron = "0 * * * * *") //매분 0초 마다 실행
	public void checkFiles() throws Exception{
		
		log.warn("File Check Task run..............");
		log.warn(new Date());
		//file list in database
		List<BoardAttachVO> fileList = attachMapper.getOldFiles();
		
		//ready for check file in directory with database file list
		List<Path> fileListPaths = fileList.stream().map(vo -> Paths.get("C:\\upload", vo.getUploadPath(),
				vo.getUuid() + "_" + vo.getFileName())).collect(Collectors.toList());
		
		
		//image file has thumnail file
		fileList.stream().filter(vo -> vo.isFileType() == true).map(vo -> Paths.get("C:\\upload", vo.getUploadPath(), "s_" +
				vo.getUuid() + "_" +vo.getFileName())).forEach(p -> fileListPaths.add(p));
		
		log.warn("==================================");
		log.warn("getFolderYesterDay: " +getFolderYesterDay());
		fileListPaths.forEach(p -> log.warn(p));
		
		//files in yesterday directory
		File targetDir = Paths.get("C:\\upload", getFolderYesterDay()).toFile();
				
		
		File[] removeFiles = targetDir.listFiles(file -> fileListPaths.contains(file.toPath()) == false);
		
		log.warn("-----------------------------------------");
		
		for(File file : removeFiles) {
			
			log.warn(file.getAbsolutePath());
			file.delete();
		}
		
		
	}
	
	
	
//	@Scheduled(cron="0 * * * * *") // 매분 0초 마다 실행
//	public void checkFiles() throws Exception{
//		
//		log.warn("File Check Task run...............");
//		
//		log.warn("=====================================");
//	}
}
