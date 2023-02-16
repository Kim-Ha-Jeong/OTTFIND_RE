import { useEffect, useRef, useState } from 'react';
import styled from 'styled-components';

const SearchBar = () => {
  const [click, setClick] = useState(false);
  const [search, setSearch] = useState({ enter: false, title: '' });
  const inputRef = useRef<HTMLDivElement>(null);

  const onChangeHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    setSearch({ enter: false, title: e.target.value });
  };

  const onKeyPressHandler = (e: React.KeyboardEvent<HTMLInputElement>) => {
    if (e.key === 'Enter') setSearch({ enter: true, title: search.title });
  };

  const onClickHandler = () => {
    click
      ? (setClick(false), setSearch({ enter: false, title: '' }))
      : setClick(true);
  };

  const outSideClickHandler = (e: any) => {
    if (
      inputRef.current === null ||
      (inputRef.current && !inputRef.current.contains(e.currentTarget))
    ) {
      setClick(false);
      setSearch({ enter: false, title: '' });
    }
  };

  useEffect(() => {
    if (click) {
      document.addEventListener('click', outSideClickHandler);
    }
    return () => {
      document.removeEventListener('click', outSideClickHandler);
    };
  });
  return (
    <Wrapper ref={inputRef}>
      <Input
        placeholder='영화나 드라마 제목을 입력하세요'
        onChange={onChangeHandler}
        onKeyPress={onKeyPressHandler}
        onClick={onClickHandler}
      ></Input>
    </Wrapper>
  );
};

const Wrapper = styled.div``;

const Input = styled.input`
  background-color: black;
  border: 1px solid rgba(255, 255, 255, 0.2);
  height: 40px;
  width: 650px;
  padding-left: 10px;
  font-size: 15px;
  color: white;
  font-weight: bold;
`;

export default SearchBar;
