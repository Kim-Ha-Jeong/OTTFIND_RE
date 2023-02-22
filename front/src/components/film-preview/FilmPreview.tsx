import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '@/modules';

import { setSEARCH } from '@/modules/setSearch';

const FilmPreview = (props: PropsType) => {
  const film = props.film;
  const nav = useNavigate();
  const dispatch = useDispatch();
  const setSearch = (enter: boolean, title: string) =>
    dispatch(setSEARCH(enter, title));

  const onClickHandler = (e: any) => {
    setSearch(false, '');
    nav(`/film/${film.id}`);
  };

  return (
    <Wrapper onClick={onClickHandler}>
      <Img src={`/poster/${film.poster_url}`} />
      <Content>
        <Title>{film.title}</Title>
        <Desc>
          {film.type}, {film.year}
        </Desc>
        <Desc>
          {film.country}, {film.genre.name}
        </Desc>
      </Content>
    </Wrapper>
  );
};

type FilmType = {
  country: string;
  director: string;
  id: number;
  genre: { id: number; name: string };
  poster_url: string;
  season: number;
  time: number;
  title: string;
  type: string;
  year: number;
  content: string;
};

type PropsType = {
  key: number;
  film: FilmType;
};

const Wrapper = styled.div`
  width: 100%;
  margin-bottom: 2%;
  font-size: 20px;
  color: white;
  display: flex;
  flex-direction: row;
  border-bottom: 1px solid rgba(255, 255, 255, 0.3);
`;

const Img = styled.img`
  width: 10%;
  padding: 0 1% 2% 1%;
`;

const Content = styled.div`
  width: 100%;
  padding-left: 1.5%;
  display: flex;
  flex-direction: column;
`;

const Title = styled.p`
  font-size: 20px;
  font-weight: bold;
  width: 100%;
  margin-bottom: 20px;
`;

const Desc = styled(Title)`
  font-size: 15px;
  font-weight: 400;
  color: rgba(255, 255, 255, 0.5);
`;

export default FilmPreview;
