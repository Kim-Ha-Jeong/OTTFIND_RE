import styled from 'styled-components';

import get from '@/modules/get';
import FilmPreviewBox from '@/components/film-preview/FilmPreviewBox';

import { useDispatch } from 'react-redux';
import { useSelector } from 'react-redux';

import { RootState } from '@/modules';
import { setFILM } from '@/modules/setFilm';
import { useEffect } from 'react';

const SearchModal = () => {
  const click = useSelector((state: RootState) => state.setClick.click);
  const search = useSelector((state: RootState) => state.setSearch);
  const dispatch = useDispatch();

  const getFilms = async () => {
    dispatch(setFILM(false, []));
    const film = await get({
      pathname: 'film',
      params: { title: search.title },
    });

    if (film.status == 200) {
      if (film.data.length > 0) {
        dispatch(setFILM(true, film.data));
      }
    }
  };

  useEffect(() => {
    getFilms();
  }, [search]);

  return (
    <Wrapper>
      {click ? <FilmPreviewBox data='' title={search.title} /> : ''}
    </Wrapper>
  );
};

const Wrapper = styled.div`
  width: 662px;
  position: absolute;
  background-color: black;
  top: 76px;
  left: 729px;
`;

export default SearchModal;
