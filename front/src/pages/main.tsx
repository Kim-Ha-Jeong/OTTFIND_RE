import styled from 'styled-components';

const Main = () => {
  const ott = ['Netflix', 'Watcha', 'Wavve', 'Tving', 'Disney'];
  return (
    <Wrapper>
      {/* <Header /> */}
      {/* <FilterWrapper>{ott.map((ele, idx) => (<OttBtn name={ele} key={idx} />))}</FilterWrapper> */}
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
