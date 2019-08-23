package g4.mini.reservation.dao;

import g4.mini.vo.Reservation;
import g4.mini.vo.Store;

public interface ReservationMapper {
	
	int userCheck(String userId);
	public Integer selectRsvNo(int stoNo); //대기번호 출력
	void updateSto(Store sto); //인원 업데이트
	void userRsv(Reservation rev); //대기번호 존재 할 시 대기걸린 유저
	int checkMyRsv(int userNo); //예약을 했는지 안했는지 확인
	String stoName(int stoNo);
	Reservation checkRsv(String userId);
	int rsvCount(int stoNo);
	int selectRsv(String userId);
	int selectStoNo(String userId);
	Reservation getRsv(String userId);
	void updateStore(Store sto);
	int selectMinRsvNo(int stoNo);
	void deleteMember(int stoNo);
	void cancelRsv(String userId);
}
