import styled from 'styled-components';
interface HighlightProps {
  current: string;
}

const Link = ({ changeType, id, current }: propsType) => {
  return (
    <Wrapper onClick={changeType} id={id} current={current}>
      {id}
    </Wrapper>
  );
};
export default Link;

type propsType = {
  changeType: (e: React.MouseEvent<HTMLDivElement>) => void;
  id: string;
  current: string;
};

const Wrapper = styled.div<HighlightProps>`
  border-bottom: ${(props) =>
    props.id === props.current ? '3px solid white' : 'none'};
  font-size: 23px;
  font-weight: bold;
  opacity: 1;
  padding: 10px;
  &:hover {
    cursor: pointer;
    opacity: 0.5;
  }
`;
