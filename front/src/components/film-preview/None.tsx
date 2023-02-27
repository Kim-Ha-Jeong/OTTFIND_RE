import styled from 'styled-components';

const None = () => {
  return (
    <Wrapper>
      <P>검색 결과가 없습니다 :( 다시 검색해보세요!</P>
      <P>( 한국 OTT에 존재하지 않는 드라마/ 영화는 검색되지 않습니다! )</P>
    </Wrapper>
  );
};

const Wrapper = styled.div`
  width: 100%;
`;

const P = styled.p`
  margin-bottom: 20px;
  font-size: 15px;
`;

export default None;
