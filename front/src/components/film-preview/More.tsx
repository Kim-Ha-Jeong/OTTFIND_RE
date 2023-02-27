import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

import { setSEARCH } from '@/modules/setSearch';
import { useDispatch } from 'react-redux';

const More = ({ title }: PropsType) => {
  const nav = useNavigate();
  const dispatch = useDispatch();
  const setSearch = (enter: boolean, title: string) =>
    dispatch(setSEARCH(enter, title));

  const onClickHandler = () => {
    setSearch(false, '');
    nav(`/film/title/${title}`);
  };
  return <Wrapper onClick={onClickHandler}>검색 결과 더 보기</Wrapper>;
};

type PropsType = {
  title: string;
};

const Wrapper = styled.div`
  width: 100%;
`;

export default More;
