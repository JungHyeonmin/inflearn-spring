# drop table: 기존에 존재하는 테이블을 삭제하는 명령어
# IF EXISTS: "실제로 존재할 때"라는 조건문
# CASCADE: 테이블과 관련된 다른 모든 종속성(외래키 제약 조건 등)을 함께 삭제한다.
drop table if exists member CASCADE;

# CREATE TABLE: 테이블 생성
CREATE TABLE member
(
    # id: 고유 식별자로 사용할 칼럼 # BIGINT: 8바이트 크기의 큰 정수를 저장 가능 # AUTO_INCREMENT: 새로운 레코드(행)이 삽입될 때마다 자동으로 증가
    id   BIGINT AUTO_INCREMENT,
    # name: 두번째 컬럼 # VARCHAR(255): 최대 255자의 가변 길이 문자열을 저장할 수 있는 문자열 생성
    name VARCHAR(255),
    # PRIMARY KEY : 테이블에서 각 레코드를 고유하게 식별하는 칼럼(열)을 지정
    PRIMARY KEY (id)
);

