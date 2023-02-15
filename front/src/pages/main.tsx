import styled from 'styled-components';
import OttBtnContainer from '@/container/OttBtnContainer';
import HeaderContainer from '@/container/HeaderContainer';

const Main = () => {
  const ott = ['Netflix', 'Watcha', 'Wavve', 'Tving', 'Disney'];
  return (
    <Wrapper>
      <HeaderContainer />
      <FilterWrapper>
        {ott.map((ele, idx) => (
          <OttBtnContainer name={ele} opt='' key={idx} />
        ))}
      </FilterWrapper>
    </Wrapper>
  );
};

const Wrapper = styled.div`
  margin: 1%;
`;

const FilterWrapper = styled.div`
  display: flex;
  flex-direction: row;
  margin: 2% 2% 0 2%;
`;

export default Main;
