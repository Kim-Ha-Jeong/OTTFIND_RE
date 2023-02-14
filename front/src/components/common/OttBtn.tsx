import styled from 'styled-components';

const OttBtn = ({ name, opt, onChange }: BtnProps) => {
  return (
    <Wrapper onClick={() => onChange(name, opt)}>
      <Img opt={opt} src={`/ott/${name}.png`} />
      <P>{opt !== '정기권' ? opt : ''}</P>
    </Wrapper>
  );
};

type BtnProps = {
  name: string;
  opt: string;
  onChange: (name: string, opt: string) => void;
};

type SizeType = {
  opt: string;
};

const Wrapper = styled.div`
  margin-right: 30px;
`;

const P = styled.p`
  margin-bottom: 20px;
  font-size: 15px;
  text-align: center;
`;

const Img = styled.img<SizeType>`
  width: ${(p) => (p.opt === '' ? '55px' : '75px')};
  margin-bottom: 10px;
`;

export default OttBtn;
