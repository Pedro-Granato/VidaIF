# 📐 Como Preparar Imagens Para Não Cortarem

## 🎯 Problema Resolvido

Voltei o `scaleType` para `centerCrop` para não sobrar espaço vazio.

Agora as imagens **preenchem todo o espaço**, mas podem cortar um pouco nas bordas se não estiverem na proporção correta.

---

## ✅ Solução: Use Imagens na Proporção Certa

### **📱 Proporções Ideais:**

#### **Banners (Carrossel Principal):**
```
Proporção: 16:5 (largura x altura)
Exemplos de tamanho:
  - 1920 x 600 pixels  ← Ideal
  - 1600 x 500 pixels
  - 1280 x 400 pixels
```

#### **Destaques:**
```
Proporção: 21:9 ou 2:1 (largura x altura)
Exemplos de tamanho:
  - 1200 x 600 pixels  ← Ideal
  - 1000 x 500 pixels
  - 800 x 400 pixels
```

---

## 🛠️ Como Redimensionar Suas Imagens

### **Opção 1: Online (Mais Fácil)**

#### **1. Usar Canva (Grátis):**

1. Acessar: **https://www.canva.com/**
2. Criar conta grátis
3. **"Criar um design" → "Tamanho personalizado"**
4. **Banners:** `1920 x 600 pixels`
5. **Destaques:** `1200 x 600 pixels`
6. Fazer upload da sua foto
7. Redimensionar para caber
8. Baixar

---

#### **2. Usar ILoveIMG (Grátis):**

1. Acessar: **https://www.iloveimg.com/pt/redimensionar-imagem**
2. Fazer upload da imagem
3. Escolher **"Por pixels"**
4. **Banners:** `1920 x 600`
5. **Destaques:** `1200 x 600`
6. Marcar **"Não manter proporção"** (vai esticar um pouco)
7. Baixar

---

#### **3. Usar Photopea (Grátis - tipo Photoshop):**

1. Acessar: **https://www.photopea.com/**
2. Abrir sua imagem
3. **Imagem → Tamanho da tela**
4. **Banners:** `1920 x 600`
5. **Destaques:** `1200 x 600`
6. Centralizar conteúdo importante
7. **Arquivo → Exportar como → JPG**

---

### **Opção 2: No Computador**

#### **Windows - Paint:**

1. Abrir imagem no Paint
2. **Redimensionar** (Ctrl + W)
3. **Desmarcar** "Manter proporção"
4. **Banners:** `1920 x 600`
5. **Destaques:** `1200 x 600`
6. Salvar

---

## 🎨 Dica Para Não Cortar Partes Importantes

### **Regra de Ouro:**

Ao criar/editar imagens para o app:

1. **Deixe margens de segurança:**
   - 10% nas laterais
   - 10% em cima e embaixo

2. **Centralize o conteúdo importante:**
   - Textos no centro
   - Pessoas/logos no centro

3. **Evite informações nas bordas:**
   - Não coloque texto nos cantos
   - Não coloque rostos nas bordas

---

## 📊 Comparação Visual:

### ❌ **ERRADO (vai cortar):**
```
┌─────────────────────────┐
│TEXTO                    │ ← Muito nas bordas
│        Foto             │
│                    TEXTO│ ← Vai cortar
└─────────────────────────┘
```

### ✅ **CERTO (não corta):**
```
┌─────────────────────────┐
│                         │
│      TEXTO + FOTO       │ ← Tudo centralizado
│      NO CENTRO          │
└─────────────────────────┘
```

---

## 🖼️ Template Pronto (Use Este!)

### **Para Banners (1920x600):**

Baixe templates prontos:
- https://www.canva.com/templates/?query=web%20banner

Ou crie do zero:
1. Canva → Tamanho personalizado: `1920 x 600`
2. Adicionar sua foto de fundo
3. Adicionar texto centralizado
4. Baixar

---

### **Para Destaques (1200x600):**

1. Canva → Tamanho personalizado: `1200 x 600`
2. Adicionar imagem
3. Adicionar texto (se quiser)
4. Baixar

---

## 🎯 Exemplo Prático:

### **Sua Foto do IFSP:**

A foto que você enviou tem 5 pessoas. Para não cortar ninguém:

1. **Abrir no Canva**
2. **Criar design: 1200 x 600**
3. **Upload da foto**
4. **Redimensionar** para que todas as pessoas apareçam
5. **Pode adicionar:**
   - Faixa de texto embaixo com o título
   - Logo do IFSP
6. **Baixar como JPG**
7. **Renomear:** `destaque1.jpg`
8. **Substituir** no projeto

---

## 📱 Tamanhos dos Cards no App:

### **Banner:**
- Altura: 200dp
- Largura: Tela inteira
- Proporção ideal: 16:5

### **Destaque:**
- Altura da imagem: 120dp
- Largura: Tela inteira
- Proporção ideal: 21:9 ou 2:1

---

## 🔧 Se Ainda Assim Cortar:

Tem 3 opções:

### **Opção 1: Ajustar a Imagem (Recomendado)**
- Redimensionar para proporção correta
- Centralizar conteúdo importante

### **Opção 2: Trocar scaleType (Vai sobrar espaço)**
```
android:scaleType="fitCenter"
```
→ Mostra imagem completa mas sobra espaço

### **Opção 3: Altura Dinâmica (Avançado)**
- Modificar layout para altura automática
- Cada imagem terá altura diferente

---

## 💡 Ferramentas Úteis:

### **Redimensionar:**
- https://www.iloveimg.com/pt/redimensionar-imagem
- https://www.canva.com/
- https://www.photopea.com/

### **Comprimir (Diminuir tamanho do arquivo):**
- https://tinypng.com/
- https://compressor.io/

### **Converter para WebP (Melhor formato):**
- https://squoosh.app/

---

## 📋 Checklist Antes de Usar Imagem:

- [ ] Tamanho correto (1920x600 ou 1200x600)
- [ ] Conteúdo importante centralizado
- [ ] Sem textos nas bordas
- [ ] Arquivo menor que 500KB
- [ ] Nome em minúsculo sem espaços
- [ ] Formato: .jpg, .png ou .webp

---

## 🎨 Resultado Final:

### **Com imagens na proporção certa:**
```
✅ Preenche todo o espaço
✅ Não corta partes importantes
✅ Visual profissional
✅ Carregamento rápido
```

---

## 🆘 Precisa de Ajuda?

Se tiver dificuldade, me mande:
1. A imagem original
2. Para qual card vai (banner ou destaque)
3. Te ajudo a redimensionar!

---

**Resumo:** Use imagens `1920x600` para banners e `1200x600` para destaques, com conteúdo centralizado! 😊
